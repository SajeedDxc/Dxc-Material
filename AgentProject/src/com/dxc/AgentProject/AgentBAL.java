package com.dxc.AgentProject;

import java.io.IOException;
import java.util.List;

public class AgentBAL {
	
	static StringBuilder sb;
	
	public boolean validAgent(Agent agent) {
		sb= new StringBuilder("");
		boolean isValid= true;
		if(agent.getAgentid()<=0) {
			sb.append("Agent Id Cannot be Negative");
			isValid=false;
		}
		if(agent.getFirstname().length()< 3 || agent.getFirstname().indexOf(" ") !=-1) {
			sb.append("\nFirstName must contain min 3 char. and no spaces are allowed.");
			isValid=false;
		}
		if(agent.getLastname().length()<3 || agent.getLastname().indexOf(" ") !=-1){
			sb.append("\nLastName must contain min 3 char. and no spaces are allowed.");
			isValid=false;
		}
		if((agent.getGender().toLowerCase().equals("male")) ||  (agent.getGender().toLowerCase().equals("female"))){
			isValid=true;
			}
		else {
			sb.append("\nGender Entered is Invalid.");
			isValid=false;
		}
	  if(agent.getPaymode()>3 || agent.getPaymode()<0) {
		  sb.append("\nPayment mode entered is Invalid. It has to be 1 or 2 or 3.");
		  isValid=false;
	  }
	   if(agent.getAnnualPremium()<25000 || agent.getAnnualPremium()>100000) {
		   sb.append("\nAmount Entered is out of range.");
		   isValid=false;
	   }
	   return isValid;
}
	
	public String addAgentBal(Agent agent) throws AgentException {
		if(validAgent(agent) == true) {
			AgentDAL dal = new AgentDAL();
			return dal.addAgentDal(agent);
		}else
			throw new AgentException(sb.toString());		
	}
	
	public List<Agent> showAgentBal(){
		AgentDAL dal= new AgentDAL();
		return dal.showAgentDal();
	}
	
	public String writeAgentFileDal() throws IOException {
		AgentDAL dal = new AgentDAL();
		return dal.writeAgentFileDal();
	}
	
	public String readAgentFileDal() throws ClassNotFoundException, IOException {
		AgentDAL dal = new AgentDAL();
		return dal.readAgentFileDal();
	}
	
	public Agent searchAgentBal(int agentid) {
		AgentDAL dal = new AgentDAL();
		return dal.searchAgentDal(agentid);
	}
	
	public String updateAgentBal(Agent agent) throws AgentException {
		if (validAgent(agent) == true) {
			AgentDAL dal = new AgentDAL();
			return dal.updateAgentDal(agent);
		} else {
			throw new AgentException(sb.toString());
		}
	}
	
	public String deleteAgentBal(int agentid) {
		AgentDAL dal = new AgentDAL();
		return dal.deleteAgentDal(agentid);
	}
	
}