package com.edi.socialnetwork.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.edi.socialnetwork.dao.UserDAO;
import com.edi.socialnetwork.model.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;


public class AddFriend extends ActionSupport implements SessionAware{
	
	private String name;
	private Map<String,Object> userSession;
	
	@Override
	public void validate() {
		
		if(StringUtils.isEmpty(name)){
			addFieldError("name","Name Cannot Be Empty");
			return;
		}
		
		UserDAO dao=new UserDAO();
		List<User> users=dao.getUserByName("currentUser");
		User currentUser=(User) userSession.get("currentUser");
		
		if(users.isEmpty()){
			addFieldError("name", "User Does Not Exist");
			return;
		}
		
		if(currentUser.getUserName().equals(users.get(0).getUserName())){
			addFieldError("name", "You can't add yourself");
			return;
		}
		
		for(User u : currentUser.getFriends()){
			if(u.getUserName().equals(users.get(0).getUserName())){
				addFieldError("name", "Already your friend");
				return;
			}
		}
		dao.close();
		
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserDAO  dao=new UserDAO();
		
		List<User> users=dao.getUserByName(name);
		
		User currentUser= (User)userSession.get("currentUser");
		Set<User> friends=currentUser.getFriends();
		friends.add(users.get(0));
		currentUser.setFriends(friends);
		
		dao.update(currentUser);
		dao.close();
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.userSession=session;
	}
}
