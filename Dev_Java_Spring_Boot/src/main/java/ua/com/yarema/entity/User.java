package ua.com.yarema.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="_user")
public class User extends AbstractEntity {
	
	private String login;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthday;
	
	private String photoUrl;
	
	private int version;
	
	@Column(length=13)
	private String phone;
	
	private String email;
	
	@OneToMany(mappedBy="user")
	private List<CommentToMeals> commentToMeals = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<CommentToCafes> commentToCafes = new ArrayList<>();

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CommentToMeals> getCommentToMeals() {
		return commentToMeals;
	}

	public void setCommentToMeals(List<CommentToMeals> commentToMeals) {
		this.commentToMeals = commentToMeals;
	}

	public List<CommentToCafes> getCommentToCafes() {
		return commentToCafes;
	}

	public void setCommentToCafes(List<CommentToCafes> commentToCafes) {
		this.commentToCafes = commentToCafes;
	}
	
}
