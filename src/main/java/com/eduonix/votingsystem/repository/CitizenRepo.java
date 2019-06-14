package com.eduonix.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduonix.votingsystem.Entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Long>{

	public Citizen findByName(String name) ;
		
}
