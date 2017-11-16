package com.java.dao;

import java.util.List;

import com.java.model.LoginDetail;
import com.java.model.UserDetail;

public interface UserDetailDao {

	public List<UserDetail> getAllUserDetail();

	public List<UserDetail> getUserDetailById(UserDetail userDetail);

	public String updateUser(UserDetail userDetail);
//	UserDetail userDetail
	
}
