package ua.com.yarema.model.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentView {

	private String message;
	
	private String time;
	
	private BigDecimal rate;
	
	private String user;
	
	private String cafe;
	
	private String meal;
 	
	public CommentView(String message, LocalDateTime time, BigDecimal rate, String user) {
		this.message = message;
		this.time = time.format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"));
		this.rate = rate;
		this.user = user;
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

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCafe() {
		return cafe;
	}

	public void setCafe(String cafe) {
		this.cafe = cafe;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}
	
}
