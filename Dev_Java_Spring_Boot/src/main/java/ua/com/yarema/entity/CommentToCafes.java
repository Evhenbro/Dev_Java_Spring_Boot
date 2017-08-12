package ua.com.yarema.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="comment_cafes")
public class CommentToCafes extends AbstractEntity {
	
	@Lob
	private String message;
	
	private LocalTime time;
	
	private Integer parentCommentId;
	
	private int hierarchy;
	
	@Column(name="_like")
	private int like;
	
	private int dislike;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cafe cafe;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Integer getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(Integer parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public int getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(int hierarchy) {
		this.hierarchy = hierarchy;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
