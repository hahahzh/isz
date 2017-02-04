package com.isz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isz.model.UserDetailModel;
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
	public ModelAndView createForm(@PathVariable("id")Long id,@ModelAttribute UserDetailModel userDetail,RedirectAttributes redirect) {
		userDetail = this.userDetailModelRepository.findByUserId(id);
		if(userDetail == null){
			redirect.addFlashAttribute("globalMessage", "请先完成注册");
			return new ModelAndView("redirect:/user/reg");
		}
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
			
			@RequestParam(value = "size", required = true) String size,
			@RequestParam(value = "face", required = true) String face,
			@RequestParam(value = "hair", required = true) String hair,
			@RequestParam(value = "skincolor", required = true) String skincolor,
			@RequestParam(value = "pricerange", required = true) String pricerange,
			@RequestParam(value = "body", required = true) String body,
			@Valid UserDetailModel userDetail,
			BindingResult result,
			RedirectAttributes redirect) {
		
		userDetail.setSize(this.bodySizeRepository.findOne(Long.parseLong(size)));
		userDetail.setFace(this.faceModelRepository.findOne(Long.parseLong(face)));
		userDetail.setHair(this.hairModelRepository.findOne(Long.parseLong(hair)));
		userDetail.setSkincolor(this.skinColorModelRepository.findOne(Long.parseLong(skincolor)));
		userDetail.setPricerange(this.priceRangeRepository.findOne(Long.parseLong(pricerange)));
		userDetail.setBody(this.bodyModelRepository.findOne(Long.parseLong(body)));
		userDetail.setUpdateDate(DateUtil.newDate());
//		userDetail.setAddress(address);
//		userDetail.setHeight(Integer.parseInt(height));
//		userDetail.setWeight(Integer.parseInt(weight));
		userDetail = this.userDetailModelRepository.save(userDetail);
		redirect.addFlashAttribute("globalMessage", "就等着收礼物吧！！！");
		return new ModelAndView("redirect:/home");
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
