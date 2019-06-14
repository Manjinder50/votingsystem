package com.eduonix.votingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduonix.votingsystem.Entity.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate, Long>{

}
