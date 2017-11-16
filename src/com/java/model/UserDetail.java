package com.java.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.java.model.LoginDetail;

@Entity
@Table(name="userDetail")
public class UserDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "userDetailId")
	private long userDetailId;
	
	public UserDetail() {}
	
	@Column(name = "profilePicture")
	private String profilePicture;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "dateOfBirth")
	private String dateOfBirth;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "schoolName")
	private String schoolName;
	
	@Column(name = "collegeName")
	private String collegeName;
	
	@Column(name = "workingStatus")
	private String workingStatus;
	
	@Column(name = "relationshipStatus")
	private String relationshipStatus;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "homeTown")
	private String homeTown;
	
	@Column(name = "languageKnown")
	private String languageKnown;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private LoginDetail loginDetail;

	public LoginDetail getLoginDetail() {
		return loginDetail;
	}
	public void setLoginDetail(LoginDetail loginDetail) {
		this.loginDetail = loginDetail;
	}
	public long getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(long userDetailId) {
		this.userDetailId = userDetailId;
	}
	
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String setDateOfBirth(String dateOfBirth) {
		return this.dateOfBirth = dateOfBirth;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	public String getWorkingStatus() {
		return workingStatus;
	}
	public void setWorkingStatus(String workingStatus) {
		this.workingStatus = workingStatus;
	}
	
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	
	public String getLanguageKnown() {
		return languageKnown;
	}
	public void setLanguageKnown(String languageKnown) {
		this.languageKnown = languageKnown;
	}
	
}
