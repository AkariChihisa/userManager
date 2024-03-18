package com.ch.ch6_6.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.ch6_6.entity.MyUser;
import com.ch.ch6_6.repository.MyUserRepository;
@Service
public class MyUserServiceImpl implements MyUserService{
	@Autowired
	private MyUserRepository myUserRepository;
	public int saveUser(MyUser myUser) {
		return myUserRepository.saveUser(myUser);
	}
	@Override
	public int deleteUser(Integer id) {
		return myUserRepository.deleteUser(id);
	}
	@Override
	public int updateUser(MyUser myUser) {
		return myUserRepository.updateUser(myUser);
	}
	@Override
	public List<MyUser> findAll() {
		return myUserRepository.findAll();
	}
	@Override
	public MyUser findUserById(Integer id) {
		return myUserRepository.findUserById(id);
	}

}
