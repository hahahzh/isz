package com.isz.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isz.model.BodySize;
import com.isz.model.FaceModel;
import com.isz.model.UserDetailModel;
import com.isz.model.UserModel;
import com.isz.repository.BodyModelRepository;
import com.isz.repository.BodySizeRepository;
import com.isz.repository.ConstellationRepository;
import com.isz.repository.FaceModelRepository;
import com.isz.repository.FrequencyModelRepository;
import com.isz.repository.HairModelRepository;
import com.isz.repository.HierarchyModelRepository;
import com.isz.repository.InclinationModelRepository;
import com.isz.repository.PostDayModelRepository;
import com.isz.repository.PriceRangeRepository;
import com.isz.repository.SkinColorModelRepository;
import com.isz.repository.UserDetailModelRepository;
import com.isz.repository.UserModelRepository;
import com.isz.utils.DateUtil;
import com.mysql.fabric.xmlrpc.base.Params;



@RestController
@RequestMapping("/userDetail")
public class UserDetailController {

	@Autowired
	private UserModelRepository userModelRepository;
	@Autowired
	private UserDetailModelRepository userDetailModelRepository;
	@Autowired
	private FaceModelRepository faceModelRepository;
	
	@Autowired
	private BodySizeRepository bodySizeRepository;
	
	@Autowired
	private BodyModelRepository bodyModelRepository;
	
	@Autowired
	private ConstellationRepository constellationRepository;
	
	@Autowired
	private FrequencyModelRepository frequencyModelRepository;
	
	@Autowired
	private HairModelRepository hairModelRepository;
	
	@Autowired
	private HierarchyModelRepository hierarchyModelRepository;
	
	@Autowired
	private InclinationModelRepository inclinationModelRepository;
	
	@Autowired
	private PostDayModelRepository postDayModelRepository;
	
	@Autowired
	private PriceRangeRepository priceRangeRepository;
	
	@Autowired
	private SkinColorModelRepository skinColorModelRepository;
		
	

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") UserDetailModel userDetail) {
		return new ModelAndView("userDetails/view", "userDetail", userDetail);
	}

	@RequestMapping(value = "/form/{id}",method=RequestMethod.GET)
	public ModelAndView createForm(@PathVariable("id")Long id, UserDetailModel userDetail) {
		userDetail = this.userDetailModelRepository.findByUserId(id);
		if(userDetail == null)return new ModelAndView("users/register", "userDetail", userDetail);
		ModelAndView mv = new ModelAndView("userDetails/form", "userDetail", userDetail);
		mv.addObject("sizes",bodySizeRepository.findAll());
		mv.addObject("faces",faceModelRepository.findAll());
		mv.addObject("frequencys",this.frequencyModelRepository.findAll());
		mv.addObject("hairs",this.hairModelRepository.findAll());
		mv.addObject("hierarchys",this.hierarchyModelRepository.findAll());
		mv.addObject("inclinations",this.inclinationModelRepository.findAll());
		mv.addObject("postdays",this.postDayModelRepository.findAll());
		mv.addObject("priceranges",this.priceRangeRepository.findAll());
		mv.addObject("skincolors",this.skinColorModelRepository.findAll());
		mv.addObject("constellations",this.constellationRepository.findAll());
		mv.addObject("bodys",this.bodyModelRepository.findAll());
		return mv;
	}

	@RequestMapping(value = "/form",method=RequestMethod.POST)
	public ModelAndView create(
			@PathVariable("size") String size,
			@Valid UserDetailModel userDetail, 
			BindingResult result,
			RedirectAttributes redirect) {
		
//		UserDetailModel userDetail = this.userDetailModelRepository.findByUserId(Long.parseLong(user));
//		userDetail.setUser(this.userModelRepository.findOne(user));
//		userDetail.setFace(this.faceModelRepository.findOne(face));
//		userDetail.setHair(this.hairModelRepository.findOne(hair));
//		userDetail.setSkincolor(this.skinColorModelRepository.findOne(skincolor));
//		userDetail.setPricerange(this.priceRangeRepository.findOne(pricerange));
//		userDetail.setBody(this.bodyModelRepository.findOne(body));
		userDetail.setUpdateDate(DateUtil.newDate());
//		userDetail.setAddress(address);
//		userDetail.setHeight(Integer.parseInt(height));
//		userDetail.setWeight(Integer.parseInt(weight));
		userDetail = this.userDetailModelRepository.save(userDetail);
		redirect.addFlashAttribute("globalMessage", "就等着收礼物吧！！！");
		return new ModelAndView("home");
	}

	@RequestMapping("foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

	@GetMapping(value = "modify/{id}")
	public ModelAndView modifyForm(@PathVariable("id") UserDetailModel userDetail) {
		return new ModelAndView("userDetails/form", "userDetail", userDetail);
	}
}
