package com.java.endPoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.java.model.LoginDetail;
import com.java.model.Post;
import com.java.model.UserDetail;
import com.java.dao.PostDao;
import com.java.dao.PostDaoImpl;

@Path("/post")
public class PostEndPoint {

	PostDao postDao = new PostDaoImpl();

	@GET
	@Produces("application/json")
	public List<Post> getAllPost() {
		return postDao.getAllPost();
	}
	
	@POST
	@Produces("application/json")
	public List<Post> getPostByID(@QueryParam("postId") long id) {
		Post post = new Post();
		post.setPostId(id);
		return postDao.getPostById(post);
	}
	
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public String putPost(Post post) {
		
		return postDao.updateUser(post);
		
	}
	
	@Path("/add")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String addPost(Post post)
	{
		return postDao.addPost(post);
	}
	
	@DELETE
	@Consumes("application/json")
	@Produces("application/json")
	public String deletePost(@QueryParam("postId") long postId) {
		Post post = new Post();
		post.setPostId(postId);
		postDao.deletePost(post);
		return "success";
	}
	
}
