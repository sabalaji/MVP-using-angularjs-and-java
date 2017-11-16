package com.java.dao;

import com.java.model.LoginDetail;
import java.util.List;

public interface LoginDetailDao {
	
	public List<LoginDetail> getAllLoginDetail();
	
	public String saveUser(LoginDetail user);
	
	public String updateUser(LoginDetail userDetail);
	
	public LoginDetail findUserByEmail(String email, String password);

	public List<LoginDetail> getLoginDetailByID(LoginDetail loginDetail);


}
