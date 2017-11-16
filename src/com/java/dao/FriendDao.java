package com.java.dao;

import java.util.List;

import com.java.model.Friend;

public interface FriendDao {

	public List<Friend> getFriendByReceiverId(String rEmail);
	
	public List<Friend> getFriendBySenderId(String rEmail);
	
	public String addFriendRequest(Friend friend);
	
	public String updateIsActive(String sEmail, String rEmail);

	public boolean checkPostLike(String idReceiver, String idSender);
	
}
