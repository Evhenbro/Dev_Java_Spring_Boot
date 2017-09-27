package ua.com.yarema.model.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.com.yarema.validation.annotation.UniqueOpenClose;

public class OpenCloseRequest {
	
	private Integer id;
	
	@Pattern(regexp = "^([0-2][0-3]:[0-5][0-9])|(0{1}[0-9]:[0-5][0-9])$", message="Ви ввели невірний формат часу (hh:mm).")
	@UniqueOpenClose(message="Такий час вже існує в БД.")
	@NotBlank(message="Це поле має бути заповненим.")
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
