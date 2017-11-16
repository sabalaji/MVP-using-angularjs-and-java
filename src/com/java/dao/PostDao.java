package com.java.dao;

import java.util.List;

import com.java.model.Post;

public interface PostDao {

	public List<Post> getAllPost();

	public List<Post> getPostById(Post post);

	public String updateUser(Post post);

	public String deletePost(Post post);

	public String addPost(Post post);

		
}
