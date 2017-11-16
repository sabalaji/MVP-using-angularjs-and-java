package com.java.dao;

import java.util.List;

import com.java.model.Friend;
import com.java.model.PostLike;
import com.java.util.HibernateUtil;

public class FriendDaoImpl implements FriendDao {

	HibernateUtil hibernateUtil = new HibernateUtil();

	@Override
	public List<Friend> getFriendByReceiverId(String rEmail) {
		hibernateUtil.openCurrentSessionwithTransaction();
		List<Friend> friendRequestList = (List<Friend>)hibernateUtil.getCurrentSession().createQuery("from Friend where idReceiver='"+rEmail+"'and isActive=0").list();
		hibernateUtil.closeCurrentSessionwithTransaction();
		return friendRequestList;
	}

	@Override
	public List<Friend> getFriendBySenderId(String rEmail) {
		hibernateUtil.openCurrentSessionwithTransaction();
		List<Friend> friendRequestList = (List<Friend>)hibernateUtil.getCurrentSession().createQuery("from Friend where idReceiver='"+rEmail +"'and isActive=1").list();
		hibernateUtil.closeCurrentSessionwithTransaction();
		return friendRequestList;
	}

	@Override
	public String addFriendRequest(Friend friend) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(friend);
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "success";
	}

	@Override
	public String updateIsActive(String sEmail, String rEmail) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().createQuery("update Friend set isActive=1 where idSender='"+sEmail+"' and idReceiver='"+rEmail+"'").executeUpdate();
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "updated";
	}

	@Override
	public boolean checkPostLike(String idReceiver, String idSender) {
		boolean isPostIdExistInPostLike = false;
		hibernateUtil.openCurrentSessionwithTransaction();
		Friend friend = (Friend) hibernateUtil.getCurrentSession().createQuery("from Friend where idReceiver='"+idReceiver+"' and idSender='"+idSender+"'").uniqueResult();
		hibernateUtil.closeCurrentSessionwithTransaction();
		if(friend != null) {
			isPostIdExistInPostLike = true;
		}
		return isPostIdExistInPostLike;
	}
	

	
}
