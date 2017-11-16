package com.java.dao;

import java.util.List;

import com.java.model.LoginDetail;
import com.java.model.Post;
import com.java.model.UserDetail;
import com.java.util.HibernateUtil;

public class PostDaoImpl implements PostDao {

	HibernateUtil hibernateUtil = new HibernateUtil();
	
	@Override
	public List<Post> getAllPost() {
		hibernateUtil.openCurrentSession();
		
		List<Post> user_records =(List<Post>)hibernateUtil.getCurrentSession().createQuery("from Post").list();
		
		hibernateUtil.closeCurrentSession();
		return user_records;
	} 

	@Override
	public List<Post> getPostById(Post post) {
		long id = post.getPostId();
		hibernateUtil.openCurrentSession();
		List<Post> postDetail = (List<Post>)hibernateUtil.getCurrentSession().createQuery("from Post where loginDetail = " + id).list();
		hibernateUtil.closeCurrentSession();
		return postDetail;	
	}

	@Override
	public String updateUser(Post post) {
		long postId = post.getPostId();
		String userPost = post.getUserPost();
		long id = post.getLoginDetail().getId();
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().createQuery("update Post set userPost = '"+userPost+"'where postId = '"+postId+"'").executeUpdate();		
		hibernateUtil.currentTransaction.commit();
		hibernateUtil.closeCurrentSession();		
		return "User record saved successfully ";
		
	}
	
	@Override
	public String deletePost(Post post) {
		hibernateUtil.openCurrentSessionwithTransaction();
		long postId = post.getPostId();	
		hibernateUtil.getCurrentSession().createQuery("delete from Post where postId = '"+postId+"'").executeUpdate();
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "deleted";
	}

	private List<Post> getPostByPostId(long postId) {
		long id = postId;
		hibernateUtil.openCurrentSession();
		List<Post> postById =(List<Post>)hibernateUtil.getCurrentSession().createQuery("from Post where postId = " + id).list();
		hibernateUtil.closeCurrentSession();
		return postById;	
	}

	@Override
	public String addPost(Post post) {
		long currentUserId = post.getLoginDetail().getId();
		hibernateUtil.openCurrentSessionwithTransaction();
		List<LoginDetail> loginDetail =(List<LoginDetail>)hibernateUtil.getCurrentSession().createQuery("from LoginDetail where id = '"+currentUserId+"'").list();
		post.setLoginDetail(loginDetail.get(0));
		hibernateUtil.getCurrentSession().save(post);
		hibernateUtil.closeCurrentSessionwithTransaction();
		return "success";
	}
	
}
