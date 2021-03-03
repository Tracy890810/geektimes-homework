package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public boolean register(User user) {
		return userRepo.save(user);
	}

	@Override
	public boolean deregister(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User queryUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User queryUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
