package com.isz.utils;

public class HttpSenderTest {
	public static void main(String[] args) {

		String url = "http://sms.253.com/msg/";// 应用地址
		String un = "N8958939";// 账号
		String pw = "dG0HkmvaT673d9";// 密码
		String phone = "15000993473";// 手机号码，多个号码使用","分割
		String msg = "【253云通讯】您好，你的验证码是123456";// 短信内容
		String rd = 1+"";// 是否需要状态报告，需要1，不需要0
		String ex = null;// 扩展码

		
		try {
			String returnString = HttpSender.batchSend(url, un, pw, phone, msg, rd, ex);
			System.out.println(returnString);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}
}