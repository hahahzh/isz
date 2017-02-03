package com.isz.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isz.model.CheckDigit;
import com.isz.repository.CheckDigitRepository;



@Component
public class SendSMS {

//	static String host = Play.configuration.getProperty("sms.host");
//	static String accountId = Play.configuration.getProperty("sms.accountId");
//	static String password = Play.configuration.getProperty("sms.password");
//	static String serviceId = Play.configuration.getProperty("sms.serviceId");
//	private static final String URL_SMS = Play.configuration.getProperty("sms.host")+"?username="+
//	Play.configuration.getProperty("sms.accountId")+"&password="+
//			Play.configuration.getProperty("sms.password")+"&extend="+
//	Play.configuration.getProperty("sms.extend")+"&Level=1";
//	public static boolean sendMsg(String[] phoneNos, String content) throws Exception {
//
//		EmppApi emppApi = new EmppApi();
//		RecvListener listener = RecvListener.getInstance(emppApi);
//
//		EMPPConnectResp response = emppApi.connect(host, 9981, accountId, password, listener);
//		if (response == null || !emppApi.isConnected() || !emppApi.isSubmitable()) {
//			return false;
//		}
//		
//        EMPPSubmitSM msg = (EMPPSubmitSM)EMPPObject.createEMPP(EMPPData.EMPP_SUBMIT);
//        List dstId = new ArrayList();
//        for(String m : phoneNos){
//        	dstId.add(m.trim()); 
//        }
//
//        msg.setDstTermId(dstId);
//        msg.setSrcTermId(accountId);
//        msg.setServiceId(serviceId);
//
//        EMPPShortMsg msgContent = new EMPPShortMsg(EMPPShortMsg.EMPP_MSG_CONTENT_MAXLEN);
//
//         try {
//                 msgContent.setMessage(content.getBytes("GBK"));
//                 msg.setShortMessage(msgContent);
//                 msg.assignSequenceNumber();
//                 emppApi.submitMsgAsync(msg);
//         } catch (Exception e) {
//                 e.printStackTrace();
//                 play.Logger.error("Send Message error. msg:"+msg);
//                 return false;
//         }
//         return true;
//	}
	
	public static String sendMsg(String phoneNo, String content) throws  IOException, URISyntaxException{
//		String path = URL_SMS + "&mobile=" + phoneNo + "&content="+content;
//		String s = HttpRequestSend.sendRequestGet_Str(path);
		return "111111";
	}
	@Autowired
	private CheckDigitRepository checkDigitRepository;
	public void checkDigit(Long m_number) {
		
		Random r = new Random();
		int sum = 0;
		for(int i=1;i<=1000;i=i*10){
			int n = 0;
			while(n==0)n = r.nextInt(10);
			sum += n*i;
		}
		
		try {
			String s = SendSMS.sendMsg(String.valueOf(m_number), sum+"【Watch】");
			if(!s.startsWith("result=0")){
//				play.Logger.error("checkDigit: result="+s+" PNumber="+m_number+" digit="+n);
//				renderText(play.i18n.Messages.get("error_verification_code"));
			}
			
			CheckDigit cd = new CheckDigit();
			cd.d = sum;
			cd.updatetime = new Date().getTime();
			cd.m = m_number;
			checkDigitRepository.save(cd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		try {
//			// 结论：字数多的情况下可以正常显示，字数少的情况下出现乱码
//			String str = "否功看是否能否功看是否能否功看是否能否功看是否能否功看是否能否功看是否能否功看是否功看是否能否功看是否能否功看是否能能是否能否功看是否能能";
//
//			String s0 = UTF2GBK.GBK2Unicode("测试");
//            String s1 = UTF2GBK.GBK2Unicode(str);
//            String s2 = UTF2GBK.unicodeToUtf8(str);
//
//			SendSMS.sendMsg("15000993473", str);
//			
////			String tt = IOUtils.toString(IOUtils.toInputStream(utf8, "GBK"));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
    
	}
}