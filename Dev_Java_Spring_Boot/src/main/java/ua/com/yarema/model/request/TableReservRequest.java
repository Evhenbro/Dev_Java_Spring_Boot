package ua.com.yarema.model.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.com.yarema.validation.flag.TableReservRequestFlag;

public class TableReservRequest {
	
	@NotBlank(message="Це поле має бути заповненим.", groups=TableReservRequestFlag.class)
 	private String user;
	
	@Pattern(regexp = "^\\+{1}[0-9]{3}[0-9]{6,12}$", message="Введено невірний формат.", groups=TableReservRequestFlag.class)
 	private String userPhone;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
}
