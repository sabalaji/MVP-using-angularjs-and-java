package com.java.endPoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.codehaus.jettison.json.JSONObject;

import java.util.List;

import com.java.model.LoginDetail;
import com.java.dao.LoginDetailDao;
import com.java.dao.LoginDetailDaoImpl;

@Path("/user")
public class LoginDetailEndPoint {
	
	LoginDetailDao loginDetailDao = new LoginDetailDaoImpl();

	@GET
	@Produces("application/json")
	public List<LoginDetail> getAllLoginDetail()
	{
		return loginDetailDao.getAllLoginDetail();
	}

	@POST
	@Produces("application/json")
	public List<LoginDetail> getLoginDetailByID(@QueryParam("loginDetailId") long id)
	{
			LoginDetail loginDetail = new LoginDetail();
			loginDetail.setId(id);
			return loginDetailDao.getLoginDetailByID(loginDetail);
	}

	@Path("/auth")
	@POST
	@Produces("application/json")
	public String authUserByEmail( LoginDetail user1) throws Exception
	{
		String email = user1.getEmail();
		String password = user1.getPassword();
		
		LoginDetail user = loginDetailDao.findUserByEmail(email,password);
		
		String response="";
		JSONObject jsonObject = new JSONObject();
		
		if(email.equalsIgnoreCase(user.getEmail()) && password.equalsIgnoreCase(user.getPassword())) {
			
			jsonObject.put("Status", "Success");
			jsonObject.put("email", user.getEmail());
			jsonObject.put("id", user.getId());
			
			response = jsonObject.toString().replace("\\", " ");
			
		}
		
		else {
			jsonObject.put("Status", "Failure");
			response = jsonObject.toString().replace("\\", " ");
		}
		return response;
	}

	@Path("/add")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addUser(LoginDetail loginDetail)
	{
		return loginDetailDao.saveUser(loginDetail);
	}
	
	@Path("/update")
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public String updateUser(LoginDetail loginDetail)
	{
		return loginDetailDao.updateUser(loginDetail);
	}
	
}
