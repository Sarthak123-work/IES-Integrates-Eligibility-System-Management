package com.IES.DC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IES.DC.Entity.User;

@Repository
public interface AuthenticationRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
