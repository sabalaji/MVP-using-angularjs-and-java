package com.java.dao;

import java.util.List;

import com.java.model.PostLike;

public interface PostLikeDao {

	public List<PostLike> getPostLikeByPostId(long postId);

	public String addPostLike(PostLike postLike);

	public boolean checkPostLike(long postId, String userEmail);

	
}
