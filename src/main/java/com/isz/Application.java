package com.isz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.client.RestTemplate;

import com.isz.model.BodyModel;
import com.isz.model.BodySize;
import com.isz.model.Constellation;
import com.isz.model.FaceModel;
import com.isz.model.FrequencyModel;
import com.isz.model.HairModel;
import com.isz.model.HierarchyModel;
import com.isz.model.InclinationModel;
import com.isz.model.PostDayModel;
import com.isz.model.PriceRange;
import com.isz.model.SkinColorModel;
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



@SpringBootApplication
@Configuration
@EnableAutoConfiguration 
public class Application implements CommandLineRunner {

	  
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	public UserModelRepository userModelRepository;
	@Autowired
	public UserDetailModelRepository userDetailModelRepository;
	@Autowired
	private BodySizeRepository bodySizeRepository;
	
	@Autowired
	private FaceModelRepository faceModelRepository;
	
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
	@Bean
	public Converter<String, UserModel> userConverter() {
		return new Converter<String, UserModel>() {
			@Override
			public UserModel convert(String id) {
				return userModelRepository.findOne(Long.valueOf(id));
			}
		};
	}
	
	@Bean
	public Converter<String, UserDetailModel> userDetailModelConverter() {
		return new Converter<String, UserDetailModel>() {
			@Override
			public UserDetailModel convert(String id) {
				return userDetailModelRepository.findOne(Long.valueOf(id));
			}
		};
	}
	
	@Bean
	public Converter<String, BodySize> bodySizeConverter() {
		return new Converter<String, BodySize>() {
			@Override
			public BodySize convert(String id) {
				return bodySizeRepository.findOne(Long.valueOf(id));
			}
		};
	}
	@Bean 
	public Converter<String, FaceModel> faceModelConverter() {
		return new Converter<String, FaceModel>() {
		@Override 
	public FaceModel convert(String id) {
	return faceModelRepository.findOne(Long.valueOf(id));
		}
	};
	}
	@Bean 
	public Converter<String, BodyModel> bodyModelConverter() {
		return new Converter<String, BodyModel>() {
		@Override 
	public BodyModel convert(String id) {
	return bodyModelRepository.findOne(Long.valueOf(id));
		}
	};
	}
	@Bean 
	public Converter<String, Constellation> constellationConverter() {
		return new Converter<String, Constellation>() {
		@Override 
	public Constellation convert(String id) {
	return constellationRepository.findOne(Long.valueOf(id));
		}
	};
	}
	@Bean 
	public Converter<String, FrequencyModel> frequencyModelConverter() {
		return new Converter<String, FrequencyModel>() {
		@Override 
	public FrequencyModel convert(String id) {
	return frequencyModelRepository.findOne(Long.valueOf(id));
		}
	};
	}
	@Bean 
	public Converter<String, HairModel> hairModelConverter() {
		return new Converter<String, HairModel>() {
		@Override 
	public HairModel convert(String id) {
	return hairModelRepository.findOne(Long.valueOf(id));
		}
	};
	}
	@Bean 
	public Converter<String, HierarchyModel> hierarchyModelConverter() {
		return new Converter<String, HierarchyModel>() {
		@Override 
	public HierarchyModel convert(String id) {
	return hierarchyModelRepository.findOne(Long.valueOf(id));
		}
	};
	}
	@Bean 
	public Converter<String, InclinationModel> inclinationModelConverter() {
		return new Converter<String, InclinationModel>() {
		@Override 
	public InclinationModel convert(String id) {
	return inclinationModelRepository.findOne(Long.valueOf(id));
		}
	};
	}
	@Bean 
	public Converter<String, PostDayModel> postDayModelConverter() {
		return new Converter<String, PostDayModel>() {
		@Override 
	public PostDayModel convert(String id) {
	return postDayModelRepository.findOne(Long.valueOf(id));
		}
	};
	}
	@Bean 
	public Converter<String, PriceRange> priceRangeConverter() {
		return new Converter<String, PriceRange>() {
		@Override 
	public PriceRange convert(String id) {
	return priceRangeRepository.findOne(Long.valueOf(id));
		}
	};
	}
	@Bean 
	public Converter<String, SkinColorModel> skinColorModelConverter() {
		return new Converter<String, SkinColorModel>() {
		@Override 
	public SkinColorModel convert(String id) {
	return skinColorModelRepository.findOne(Long.valueOf(id));
		}
	};
	}
	@Override
	public void run(String... arg0) throws Exception {
		 new RestTemplate();  
//		 template.getForObject("http://localhost:8080/api/good?page=1&size=10", GoodModel.class);  
		
	}

}
