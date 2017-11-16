package com.java.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post implements Serializable {

	private static final long serialVersionUID = -6075023895671249660L;

	@Id
	@GeneratedValue
	@Column(name = "postId")
	private long postId;
	
	@Column(name = "userPost")
	private String userPost;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	LoginDetail loginDetail;//composition has-a relationship 

	public LoginDetail getLoginDetail() {
		return loginDetail;
	}
	
	public void setLoginDetail(LoginDetail loginDetail) {
		this.loginDetail = loginDetail;
	}

	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getUserPost() {
		return userPost;
	}
	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}
	
}
