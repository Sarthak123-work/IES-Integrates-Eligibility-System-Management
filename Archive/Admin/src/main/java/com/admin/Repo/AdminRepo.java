package com.admin.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.Entity.PlanMaster;

public interface AdminRepo extends JpaRepository<PlanMaster, Integer>{

}
