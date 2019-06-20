package com.supcrowdfunder.dao;

import java.util.List;

import com.supcrowdfunder.entity.User;

public interface UserDao {
	
    public User addUser(User user);	
    
    public User retrieveUserById(Long id);	

    public List<User> retrieveAllUsers();
    
    public void removeUser(Long id);
    
    public void updateUser(Long id,String email,String fname,String lname,String pwd);

}
