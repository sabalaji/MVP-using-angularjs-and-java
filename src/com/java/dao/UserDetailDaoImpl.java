package com.java.dao;

import java.util.List;

import com.java.model.UserDetail;
import com.java.util.HibernateUtil;

public class UserDetailDaoImpl implements UserDetailDao {
	
	HibernateUtil hibernateUtil = new HibernateUtil();

	@Override
	public List<UserDetail> getAllUserDetail() {
		hibernateUtil.openCurrentSession();
		List<UserDetail> userDetail_records =(List<UserDetail>)hibernateUtil.getCurrentSession().createQuery("from UserDetail").list();
		hibernateUtil.closeCurrentSession();
		return userDetail_records;
	}

	@Override
	public List<UserDetail> getUserDetailById(UserDetail userDetail) {
		long id = userDetail.getUserDetailId();
		hibernateUtil.openCurrentSession();
		List<UserDetail> loginDetailById =(List<UserDetail>)hibernateUtil.getCurrentSession().createQuery("from UserDetail where loginDetail = "+ id).list();
		hibernateUtil.closeCurrentSession();
		return loginDetailById;
	}

	@Override
	public String updateUser(UserDetail userDetail) {
	
		String CollegeName = userDetail.getCollegeName();
		String Country = userDetail.getCountry();
		String DateOfBirth = userDetail.getDateOfBirth();
		String Gender = userDetail.getGender();
		String LanguageKnown = userDetail.getLanguageKnown();
		String Name = userDetail.getName();
		String ProfilePicture = userDetail.getProfilePicture();
		String PhoneNumber = userDetail.getPhoneNumber();
		String RelationshipStatus = userDetail.getRelationshipStatus();
		String SchoolName = userDetail.getSchoolName();
		String HomeTown = userDetail.getHomeTown();
		long loginDetail = userDetail.getLoginDetail().getId();
		//long loginDetail = logindetail.getId();
		String WorkingStatus = userDetail.getWorkingStatus();
		hibernateUtil.openCurrentSessionwithTransaction();
		
		hibernateUtil.getCurrentSession().createQuery("update UserDetail set collegeName = '"+CollegeName+"' ,name='"+Name+"' ,dateOfBirth='"+DateOfBirth+"',gender='"+Gender+"' ,phoneNumber='"+PhoneNumber+"' ,schoolName='"+SchoolName+"',workingStatus='"+WorkingStatus+"' ,relationshipStatus='"+RelationshipStatus+"' ,country='"+Country+"' ,homeTown='"+HomeTown+"' ,languageKnown='"+LanguageKnown+"' where loginDetail='"+loginDetail+"' ").executeUpdate();
//		userDetail.setLoginDetail(userDetail.get(0));
		hibernateUtil.currentTransaction.commit();
		hibernateUtil.closeCurrentSession();
		return "User record saved successfully";
	}
	
}

