package com.IES.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IES.Entity.User;


@Repository
public interface AuthenticationRepo extends JpaRepository<User, Integer>{
	
	

	 User findByEmail(String email);

}
