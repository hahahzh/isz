package com.isz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "user_detail")
public class UserDetailModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@OneToOne
	private UserModel user;
	
	@ManyToOne
	private BodySize size;
	
	@ManyToOne
	private FaceModel face;
	
	@ManyToOne
	private SkinColorModel skincolor;
	
	@ManyToOne
	private PriceRange pricerange;
	
	@ManyToOne
	private HairModel hair;
	
	@ManyToOne
	private InclinationModel inclination;
	
	@ManyToOne
	private BodyModel body;
	
	@ManyToOne
	private HierarchyModel hierarchy;
	
	@ManyToOne
	private PostDayModel postDay;
	
	@ManyToOne
	private FrequencyModel frequency;
	
	private String city;
	@NotNull
	private String address;
	
	@NotNull
	private Integer height;
	@NotNull
	private Integer weight;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=javax.persistence.CascadeType.REFRESH)
	public Constellation constellation;
	@ManyToOne(fetch=FetchType.EAGER,cascade=javax.persistence.CascadeType.REFRESH)
	public Blood blood;
	
	@Column(columnDefinition="TIMESTAMP")
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateDate;
	
	public Integer getHeight() {
		return height;
	}





	public BodySize getSize() {
		return size;
	}





	public void setSize(BodySize size) {
		this.size = size;
	}





	public Constellation getConstellation() {
		return constellation;
	}





	public PriceRange getPricerange() {
		return pricerange;
	}





	public void setPricerange(PriceRange pricerange) {
		this.pricerange = pricerange;
	}





	public void setConstellation(Constellation constellation) {
		this.constellation = constellation;
	}





	public Blood getBlood() {
		return blood;
	}





	public void setBlood(Blood blood) {
		this.blood = blood;
	}





	public void setHeight(Integer height) {
		this.height = height;
	}





	public Integer getWeight() {
		return weight;
	}





	public void setWeight(Integer weight) {
		this.weight = weight;
	}





	public UserDetailModel() {
	}

	
	
	

	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public UserModel getUser() {
		return user;
	}





	public void setUser(UserModel user) {
		this.user = user;
	}





	public FaceModel getFace() {
		return face;
	}





	public void setFace(FaceModel face) {
		this.face = face;
	}





	public SkinColorModel getSkincolor() {
		return skincolor;
	}





	public void setSkincolor(SkinColorModel skincolor) {
		this.skincolor = skincolor;
	}





	public HairModel getHair() {
		return hair;
	}





	public void setHair(HairModel hair) {
		this.hair = hair;
	}





	public InclinationModel getInclination() {
		return inclination;
	}





	public void setInclination(InclinationModel inclination) {
		this.inclination = inclination;
	}





	public BodyModel getBody() {
		return body;
	}





	public void setBody(BodyModel body) {
		this.body = body;
	}





	public HierarchyModel getHierarchy() {
		return hierarchy;
	}





	public void setHierarchy(HierarchyModel hierarchy) {
		this.hierarchy = hierarchy;
	}





	public PostDayModel getPostDay() {
		return postDay;
	}





	public void setPostDay(PostDayModel postDay) {
		this.postDay = postDay;
	}





	public FrequencyModel getFrequency() {
		return frequency;
	}





	public void setFrequency(FrequencyModel frequency) {
		this.frequency = frequency;
	}





	public Date getUpdateDate() {
		return updateDate;
	}





	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}





	public String toString() {
		return String.format("UserDetail[name='%s']", user);
	}

}
