package com.dxc.AgentProject;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AgentDAL {

	static List<Agent> agentList;
	
	static {
		agentList = new ArrayList<Agent>();
	}

public String addAgentDal(Agent agent) {
	agentList.add(agent);
	return "Agent Record successfully added....";
}
	

public List<Agent> showAgentDal(){
	return agentList;
	}

public Agent searchAgentDal(int agentid) {
	Agent agent = null;
	for(Agent a : agentList) {
		if(a.getAgentid() == agentid) {
			agent=a;
		}
	}
	return agent;
}

public String updateAgentDal(Agent agentUpdate) {
	String result= "Record not Found.";
	for (Agent agent : agentList) {
		if(agent.getAgentid()==agentUpdate.getAgentid()) {
			agent.setFirstname(agentUpdate.getFirstname());
			agent.setLastname(agentUpdate.getLastname());
			agent.setGender(agentUpdate.getGender());
			agent.setPaymode(agentUpdate.getPaymode());
			agent.setAnnualPremium(agentUpdate.getAnnualPremium());
			result="Agents Record sucessfully updated...";
		}
	}
	return result;
}

public String deleteAgentDal(int agentid) {
	Agent agentFound = searchAgentDal(agentid);
	if(agentFound !=null) {
		agentList.remove(agentFound);
		return "Agent Record Deleted....";
	}else {
		return "Agent Record Not Found to Delete...";
	}
}


public String writeAgentFileDal() throws IOException {
	FileOutputStream fout=new FileOutputStream("C:/Users/Mohammed Sajeed/AgentProject.txt");
	ObjectOutputStream objout= new ObjectOutputStream(fout);
	objout.writeObject(agentList);
	objout.close();
	fout.close();
	return "Agent Record Stored in File..."; 
	}


public String readAgentFileDal() throws IOException, ClassNotFoundException {
	FileInputStream fin = new FileInputStream("C:/Users/Mohammed Sajeed/AgentProject.txt");
	ObjectInputStream objin =new ObjectInputStream(fin);
	agentList = (List<Agent>) objin.readObject();
	return "Agent Record Retrieved from File....";
}
}