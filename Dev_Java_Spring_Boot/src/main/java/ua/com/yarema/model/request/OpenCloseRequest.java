package ua.com.yarema.model.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.com.yarema.validation.annotation.UniqueOpenClose;
import ua.com.yarema.validation.flag.OpenCloseFlag;

public class OpenCloseRequest {
	
	private Integer id;
	
	@Pattern(regexp = "^([0-2][0-3]:[0-5][0-9])|(0{1}[0-9]:[0-5][0-9])$", message="Ви ввели невірний формат часу (hh:mm).", groups={OpenCloseFlag.class})
	@UniqueOpenClose(message="Такий час вже існує в БД.", groups=OpenCloseFlag.class)
	@NotBlank(message="Це поле має бути заповненим.", groups={OpenCloseFlag.class})
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
