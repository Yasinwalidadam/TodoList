package com.edi.socialnetwork.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.edi.socialnetwork.dao.UserDAO;
import com.edi.socialnetwork.model.User;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport implements SessionAware{
	private User user;
	private Map<String,Object> userSession;
	
	
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	@Override
	public void validate() {
		
		
		if(StringUtils.isEmpty((user.getUserName()))){
			addFieldError("user.password", "Username Cannot Be Blank");
			return;
		}
		if(StringUtils.isEmpty((user.getPassword()))){
			addFieldError("user.userName", "Passeword Cannot Be Blank");
			return; 
		}
		
		UserDAO dao=new UserDAO();
		List<User> users=dao.getUserByName(user.getUserName());
		
		if(users.isEmpty()){
			addFieldError("user.userName","No User Found");
			return;
		}
		
		if(!users.get(0).equals(user.getPassword())){
			
			addFieldError("user.password","Error in password");
			return;
		}
		this.user=users.get(0);
		userSession.put("user",this.user);
		dao.close();
	}
	
	@Override
	public String execute(){
		System.out.println("we are executing loging action!");
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}
	
	
}