package com.Citizen.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Citizen.Entity.User;



@Repository
public interface AuthenticationRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
