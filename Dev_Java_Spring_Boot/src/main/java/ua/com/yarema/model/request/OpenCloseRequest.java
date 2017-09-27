package ua.com.yarema.model.request;

import ua.com.yarema.validation.annotation.UniqueOpenClose;

public class OpenCloseRequest {
	
	private Integer id;
	
	@UniqueOpenClose(message="Такий час вже існує в БД.")
	private String time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
