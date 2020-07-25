package com.dxc.bankProject;

public class Account {

	private int accountNo;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private int amount;
	private String cheqFacil;
	private String accountType;
	private String status;
	private String dateOfOpen;
	
	
	
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCheqFacil() {
		return cheqFacil;
	}

	public void setCheqFacil(String cheqFacil) {
		this.cheqFacil = cheqFacil;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateOfOpen() {
		return dateOfOpen;
	}

	public void setDateOfOpen(String dateOfOpen) {
		this.dateOfOpen = dateOfOpen;
	}

	public Account() {
		
	}

	public Account(int accountNo, String firstName, String lastName, String city, String state, int amount,
			String cheqFacil, String accountType, String status, String dateOfOpen) {
		super();
		this.accountNo = accountNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.amount = amount;
		this.cheqFacil = cheqFacil;
		this.accountType = accountType;
		this.status = status;
		this.dateOfOpen = dateOfOpen;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", firstName=" + firstName + ", lastName=" + lastName + ", city="
				+ city + ", state=" + state + ", amount=" + amount + ", cheqFacil=" + cheqFacil + ", accountType="
				+ accountType + ", status=" + status + ", dateOfOpen=" + dateOfOpen + "]";
	}
	
	
	
	
	
}
