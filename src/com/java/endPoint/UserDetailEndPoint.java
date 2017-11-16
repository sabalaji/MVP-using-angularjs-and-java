package com.java.endPoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.java.model.LoginDetail;
import com.java.model.UserDetail;
import com.java.dao.UserDetailDao;
import com.java.dao.UserDetailDaoImpl;


@Path("/userDetail")
public class UserDetailEndPoint {

	UserDetailDao userDetailDao = new UserDetailDaoImpl();

	@Path("/getAllUserDetail")
	@GET
	@Produces("application/json")
	public List<UserDetail> getAllUserDetail() {
		return userDetailDao.getAllUserDetail();
	}
	
	@POST
	@Produces("application/json")
	public List<UserDetail> getUserDetailByID(@QueryParam("userDetailId") long id) {
			UserDetail userDetail = new UserDetail();
			userDetail.setUserDetailId(id);
			return userDetailDao.getUserDetailById(userDetail);
	}
	
	@PUT
	@Consumes("application/json")
	public String updateUser(UserDetail userDetail) {
		return userDetailDao.updateUser(userDetail);
	}
	
}
