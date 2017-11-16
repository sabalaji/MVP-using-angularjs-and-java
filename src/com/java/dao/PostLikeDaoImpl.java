package com.java.dao;

import java.util.List;

import com.java.model.PostLike;
import com.java.util.HibernateUtil;

public class PostLikeDaoImpl implements PostLikeDao {

	HibernateUtil hibernateUtil = new HibernateUtil();

	@Override
	public List<PostLike> getPostLikeByPostId(long postId) {
		hibernateUtil.openCurrentSession();
		List<PostLike> likedPost =(List<PostLike>)hibernateUtil.getCurrentSession().createQuery("from PostLike where postId = "+postId).list();
		hibernateUtil.closeCurrentSession();
		return likedPost;
	}

	@Override
	public String addPostLike(PostLike postLike) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(postLike);
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "success";
	}

	@Override
	public boolean checkPostLike(long postId, String userEmail) {
		boolean isPostIdExistInPostLike = false;
		hibernateUtil.openCurrentSessionwithTransaction();
		PostLike postLike = (PostLike) hibernateUtil.getCurrentSession().createQuery("from PostLike where postId='"+postId+"' and userEmail='"+userEmail+"'").uniqueResult();
		hibernateUtil.closeCurrentSessionwithTransaction();
		if(postLike != null) {
			isPostIdExistInPostLike = true;
		}
		return isPostIdExistInPostLike;
	}

}
