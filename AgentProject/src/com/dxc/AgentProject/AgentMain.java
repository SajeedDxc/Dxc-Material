package com.dxc.AgentProject;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AgentMain {
	static AgentBAL obj =new AgentBAL();
	static Scanner sc=new Scanner(System.in);
	public static void addAgent() throws AgentException {
		Agent agent= new Agent();
		System.out.println("Enter Agentid  ");
		agent.setAgentid(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter Agent First Name  ");
		agent.setFirstname(sc.nextLine());
		System.out.println("Enter Agent Last Name  ");
		agent.setLastname(sc.nextLine());
		System.out.println("Enter Gender  ");
		agent.setGender(sc.nextLine());
		System.out.println("Enter Paymode ");
		agent.setPaymode(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter Premium Amount ");
		agent.setAnnualPremium(Double.parseDouble(sc.nextLine()));
		System.out.println(obj.addAgentBal(agent));
	}
	
	public static void searchAgent() {
		int agentid;
		System.out.println("Enter Agent  ");
		agentid=Integer.parseInt(sc.nextLine()); 
		Agent agent=obj.searchAgentBal(agentid);
		if(agent!=null) {
			System.out.println(agent);
		} else {
			System.out.println("Record not found...");
		}
	}
	
	public static void showAgent() {
		List<Agent> agents=obj.showAgentBal();
		for (Agent agent : agents) {
			System.out.println(agent);
		}
	}
	
	public static void updateAgent() throws AgentException {
		Agent agent=new Agent();
		System.out.println("Enter AgentId  ");
		agent.setAgentid(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter Agent First Name  ");
		agent.setFirstname(sc.nextLine());
		System.out.println("Enter Agent Last Name  ");
		agent.setLastname(sc.nextLine());
		System.out.println("Enter Gender  ");
		agent.setGender(sc.nextLine());
		System.out.println("Enter Paymode ");
		agent.setPaymode(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter Premium amount ");
		agent.setAnnualPremium(Double.parseDouble(sc.nextLine()));
		System.out.println(obj.updateAgentBal(agent));
	}
	
	public static void deleteAgent() {
		int agentid;
		System.out.println("Enter AgentId  ");
		agentid=Integer.parseInt(sc.nextLine());
		System.out.println(obj.deleteAgentBal(agentid));
	}
	
	
	public static void writeAgentFile() throws IOException {
		System.out.println(obj.writeAgentFileDal());
	}
	
	public static void readAgentFile() throws ClassNotFoundException, IOException {
		System.out.println(obj.readAgentFileDal());
	}

	public static void main(String[] args) {
		int ch;
		do {
			System.out.println("Options");
			System.out.println("---------");
			System.out.println("1. Add Agent");
			System.out.println("2. Show Agent");
			System.out.println("3. Search Agent");
			System.out.println("4. Update Agent");
			System.out.println("5. Delete Agent");
			System.out.println("6. Write Agent File");
			System.out.println("7. Read Agent File");
			System.out.println("8. Exit");
			System.out.println("Enter Ur Choice  ");
			ch=Integer.parseInt(sc.nextLine());
			switch(ch) {
			case 1 : 
				try {
					addAgent();
				} catch (AgentException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2 :
				showAgent();
				break;
			case 3 :
				searchAgent();
				break;
			case 4 : 
				try {
					updateAgent();
				} catch (AgentException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 5 : 
				deleteAgent();
				break;
			case 6 : 
				try {
					writeAgentFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 7 : 
				
				try {
					readAgentFile();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 8 : 
				return;
			default : 
				System.out.println("Invalid Choice");
			}
		} while(ch!=8);
	}

}

