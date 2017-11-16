package com.java.dao;

import java.util.List;

import com.java.model.LoginDetail;
import com.java.model.UserDetail;
import com.java.util.HibernateUtil;

public class LoginDetailDaoImpl implements LoginDetailDao{
	
	HibernateUtil hibernateUtil = new HibernateUtil();

	@Override
	public String saveUser(LoginDetail loginDetail) {
		hibernateUtil.openCurrentSessionwithTransaction();
		UserDetail userDetail = new UserDetail();
		userDetail.setLoginDetail(loginDetail);
		hibernateUtil.getCurrentSession().save(userDetail);
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "success";
	}

	@Override
	public List<LoginDetail> getAllLoginDetail() {
		hibernateUtil.openCurrentSession();
		List<LoginDetail> user_records =(List<LoginDetail>)hibernateUtil.getCurrentSession().createQuery("from LoginDetail").list();
		
		hibernateUtil.closeCurrentSession();
		return user_records;
	}
	
	@Override
	public String updateUser(LoginDetail userDetail) {
		hibernateUtil.openCurrentSessionwithTransaction();
		
		hibernateUtil.getCurrentSession().update(userDetail);

		
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "User record saved successfully ";
	}

	@Override
	public LoginDetail findUserByEmail(String email,String password) {
		
		hibernateUtil.openCurrentSession();
		
		LoginDetail loginDetail =(LoginDetail)hibernateUtil.getCurrentSession().createQuery("from LoginDetail where email = '"+email+"' and password= '"+password+"' and isActive=1").uniqueResult();
		
		hibernateUtil.closeCurrentSession();
		return loginDetail;
	}

	@Override
	public List<LoginDetail> getLoginDetailByID(LoginDetail loginDetail) {
		long id = loginDetail.getId();
		hibernateUtil.openCurrentSession();
		List<LoginDetail> loginDetailByID =(List<LoginDetail>)hibernateUtil.getCurrentSession().createQuery("from LoginDetail where id = "+ id).list();
		hibernateUtil.closeCurrentSession();
		return loginDetailByID;
	}

}
