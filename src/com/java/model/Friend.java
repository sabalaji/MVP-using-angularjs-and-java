package com.java.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.java.model.LoginDetail;

@Entity
@Table(name = "friend")
public class Friend {
	
	@Id
	@GeneratedValue
	@Column(name="friendId")
	private long friendId;
	
	@Column(name="idSender")
	private String idSender;
	
	@Column(name="idReceiver")
	private String idReceiver;
	
	@Column(name="isActive")
	private short isActive;

	public long getFriendId() {
		return friendId;
	}

	public void setFriendId(long friendId) {
		this.friendId = friendId;
	}

	public String getIdSender() {
		return idSender;
	}

	public void setIdSender(String idSender) {
		this.idSender = idSender;
	}

	public String getIdReceiver() {
		return idReceiver;
	}

	public void setIdReceiver(String idReceiver) {
		this.idReceiver = idReceiver;
	}

	public short isActive() {
		return isActive;
	}

	public void setActive(short isActive) {
		this.isActive = isActive;
	}
	
}
