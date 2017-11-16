package com.java.endPoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.java.dao.FriendDao;
import com.java.dao.FriendDaoImpl;
import com.java.model.Friend;

@Path("/friend")
public class FriendEndPoint {

	FriendDao friendDao = new FriendDaoImpl();
	
	@POST
	@Consumes("application/json")
	public String addFriendRequest(Friend friend) {
		
		boolean isPostIdExistInPostList = checkFriendRequest(friend.getIdReceiver(), friend.getIdSender());
		
		if (isPostIdExistInPostList == false) {
			return friendDao.addFriendRequest(friend);
		} else { return "failure"; }
		
	}
	
	private boolean checkFriendRequest(String idReceiver, String idSender) {
		return friendDao.checkPostLike(idReceiver, idSender);	
	}

	@GET
	@Produces("application/json")
	public List<Friend> getFriendByReceiverId(@QueryParam("receiverEmail") String rEmail) {
		
		return friendDao.getFriendByReceiverId(rEmail);
	
	}
	
	@Path("/getFriendBySenderId")
	@GET
	@Produces("application/json")
	public List<Friend> getFriendBySenderId(@QueryParam("receiverEmail") String rEmail) {
		
		return friendDao.getFriendBySenderId(rEmail);
	
	}
	
	@PUT
	public String updateIsActive(@QueryParam("senderEmail") String sEmail,
								 @QueryParam("receiverEmail") String rEmail) {
		return friendDao.updateIsActive(sEmail, rEmail);
	}
	
}
