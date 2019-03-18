package com.register.user.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.register.user.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	List<User> findByEmailIgnoreCaseContaining(String email);
	

}
