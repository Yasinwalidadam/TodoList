package com.edi.socialnetwork.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.edi.socialnetwork.dao.UserDAO;
import com.edi.socialnetwork.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private User user;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void validate() {
		
		if(StringUtils.isEmpty(user.getUserName())){
			addFieldError("user.userName", "Le nom d'utilisateur ne peut pas être vide");
			return;
		}
		if(StringUtils.isEmpty(user.getPassword())){
			addFieldError("user.password", "Le mot de passe ne peut pas être vide");
			return;
		}
		
		if(user.getUserName().length()>64){
			addFieldError("user.userName", "Nom trop long !!");
			return;
		}
		
		if(user.getUserName().length()>64){
			addFieldError("user.password", "Mot de passe trop long !!");
			return;
		}
		
		UserDAO dao=new UserDAO();
		if(!dao.getUserByName(user.getUserName()).isEmpty()){
			addFieldError("user.userName", "Nom d'utilisateur existe déjà");
			return;
		}
		
		
		dao.close(); 
		
		
	}
	
	@Override
	public String execute() throws Exception {
		UserDAO dao= new UserDAO();
		dao.insertUser(user);
		System.out.println("we are registring a new user!");
		dao.close();
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}
