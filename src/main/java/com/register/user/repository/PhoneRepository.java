package com.register.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.register.user.model.Phone;

public interface PhoneRepository  extends CrudRepository<Phone, Long> {
	
	

}
