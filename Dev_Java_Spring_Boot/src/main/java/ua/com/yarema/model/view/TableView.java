package ua.com.yarema.model.view;

public class TableView {

	private Integer id;
	
	private int countOfPeople;
	
	private boolean isFree;
	
	private String cafe;

	public TableView(Integer id, int countOfPeople, boolean isFree, String cafe) {
		this.id = id;
		this.countOfPeople = countOfPeople;
		this.isFree = isFree;
		this.cafe = cafe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCafe() {
		return cafe;
	}

	public void setCafe(String cafe) {
		this.cafe = cafe;
	}
	
	
	
}
