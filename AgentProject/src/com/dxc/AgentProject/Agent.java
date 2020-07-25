package com.dxc.AgentProject;


import java.io.Serializable;

public class Agent implements Serializable {
	private int agentid;
	private String firstname;
	private String lastname;
	private String gender;
	private int paymode;
	private double annualPremium;
	
	
	
	
	public int getAgentid() {
		return agentid;
	}

	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPaymode() {
		return paymode;
	}

	public void setPaymode(int paymode) {
		this.paymode = paymode;
	}

	public double getAnnualPremium() {
		return annualPremium;
	}

	public void setAnnualPremium(double annualPremium) {
		this.annualPremium = annualPremium;
	}

	public Agent() {
		
	}

	public Agent(int agentid, String firstname, String lastname, String gender, int paymode, double annualPremium) {
		super();
		this.agentid = agentid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.paymode = paymode;
		this.annualPremium = annualPremium;
	}

	@Override
	public String toString() {
		return "Agent [agentid=" + agentid + ", firstname=" + firstname + ", lastname=" + lastname + ", gender="
				+ gender + ", paymode=" + paymode + ", annualPremium=" + annualPremium + "]";
	}
	
	
	
	
}