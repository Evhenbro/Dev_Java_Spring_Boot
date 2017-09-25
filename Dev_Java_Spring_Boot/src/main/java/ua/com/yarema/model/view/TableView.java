package ua.com.yarema.model.view;

public class TableView {

	private Integer id;
	
	private String number;
	
	private int countOfPeople;
	
	private boolean isFree;
	
	private String user;
	
	private String userPhone;
	
	private String cafe;

	public TableView(Integer id, String number, int countOfPeople, boolean isFree, String user, String userPhone, String cafe) {
		this.id = id;
		this.number = number;
		this.countOfPeople = countOfPeople;
		this.isFree = isFree;
		this.user = user;
		this.userPhone = userPhone;
		this.cafe = cafe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(int countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}

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

	public String getCafe() {
		return cafe;
	}

	public void setCafe(String cafe) {
		this.cafe = cafe;
	}
	
}
