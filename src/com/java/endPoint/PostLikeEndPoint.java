package com.java.endPoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.java.dao.PostLikeDao;
import com.java.dao.PostLikeDaoImpl;
import com.java.model.PostLike;

@Path("/postLike")
public class PostLikeEndPoint {

	PostLikeDao postLikeDao = new PostLikeDaoImpl();
	
	@GET
	@Produces("application/json")
	public List<PostLike> getAllLikesByPostId(@QueryParam("postId") long postId) {
		return postLikeDao.getPostLikeByPostId(postId);
	}
	
	@POST
	@Consumes("application/json")
	public String addPostLike(PostLike postLike) {

		boolean isPostIdExistInPostList = checkPostLike(postLike.getPostId(),postLike.getUserEmail());
		
		if (isPostIdExistInPostList == false) {
			return postLikeDao.addPostLike(postLike);
		} else { return "failure"; }
		
	}
	
	public boolean checkPostLike( long postId, String userEmail) {
		return postLikeDao.checkPostLike(postId,userEmail);		
	}
	
}
