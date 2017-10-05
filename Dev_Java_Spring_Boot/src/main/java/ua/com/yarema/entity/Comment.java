package ua.com.yarema.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="comment")
public class Comment extends AbstractEntity {
	
	@Column(length=1023)
	private String message;
	
	private LocalDateTime time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Comment parentComment;
	
	@OneToMany(mappedBy="parentComment")
	private List<Comment> childComment = new ArrayList<>();
	
	private BigDecimal rate;
	
	@Column(name="_like")
	private int like;
	
	private int dislike;
	
	private String user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cafe cafe;

	@ManyToOne(fetch=FetchType.LAZY)
	private Meal meal;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Comment getParentComment() {
		return parentComment;
	}

	public void setParentComment(Comment parentComment) {
		this.parentComment = parentComment;
	}

	public List<Comment> getChildComment() {
		return childComment;
	}

	public void setChildComment(List<Comment> childComment) {
		this.childComment = childComment;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

}
