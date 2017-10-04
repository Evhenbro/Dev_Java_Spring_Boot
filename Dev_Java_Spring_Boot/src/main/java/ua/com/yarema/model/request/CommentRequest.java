package ua.com.yarema.model.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.com.yarema.entity.Cafe;
import ua.com.yarema.entity.Comment;
import ua.com.yarema.entity.Meal;

public class CommentRequest {

	private Integer id;

	private String message;
	
	private String time;
	
	private Comment parentComment;
	
	private List<Comment> childComment = new ArrayList<>();
	
	@Pattern(regexp = "^([0-9]{1}\\.{1}[0-9]{1,2})|([1]{1}[0]{1}\\.{1}[0-9]{1,2})|([0-9]{1})|(10{1})$", message="Ви ввели невірний формат(Вірно: 7 або 5.58 та максимум це 10.00).")
	private String rate;
	
	private int like;
	
	private int dislike;
	
	@NotBlank(message="Це поле не може бути пустим.")
	private String user;
	
	private Cafe cafe;

	private Meal meal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
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

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
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
