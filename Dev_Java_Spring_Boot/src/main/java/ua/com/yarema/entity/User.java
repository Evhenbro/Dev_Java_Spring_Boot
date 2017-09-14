package ua.com.yarema.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="_user")
public class User extends AbstractEntity {
	
	private String login;
	
	private String password;
	
	@Enumerated
	private Role role;
	
	@OneToMany(mappedBy="user")
	private List<Cafe> cafes = new ArrayList<>();

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Cafe> getCafes() {
		return cafes;
	}

	public void setCafes(List<Cafe> cafes) {
		this.cafes = cafes;
	}
	
	
	
//	private String email;
//	
//	private String password;
//	
//	private String firstName;
//	
//	private String lastName;
//	
//	private LocalDate birthday;
//	
//	private String photoUrl;
//	
//	private int version;
//	
//	@Column(length=13)
//	private String phone;
//	
//	private String email;
//	
//	@OneToMany(mappedBy="user")
//	private List<Comment> comments = new ArrayList<>();

}
