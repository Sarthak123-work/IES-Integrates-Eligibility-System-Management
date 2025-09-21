package com.IES.DC.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IES.DC.Entity.CitizenApplication;
import com.IES.DC.Entity.User;

@Repository
public interface CitizenArRepo extends JpaRepository<CitizenApplication, Integer> {

	Optional<List<CitizenApplication>> findByUser(User user);
}
