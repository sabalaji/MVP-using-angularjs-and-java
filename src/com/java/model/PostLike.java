package com.java.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.java.model.Post;

@Entity
@Table(name="postLike")
public class PostLike {

	@Id
	@GeneratedValue
	@Column(name = "postLikeId")
	private long postLikeId;
	
	@Column(name = "userEmail")
	private String userEmail;
	
	@Column(name = "postId")
	private long postId;

	public long getPostLikeId() {
		return postLikeId;
	}

	public void setPostLikeId(long postLikeId) {
		this.postLikeId = postLikeId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	
	
}
