package com.eduonix.votingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eduonix.votingsystem.Entity.Candidate;
import com.eduonix.votingsystem.Entity.Citizen;
import com.eduonix.votingsystem.repository.CandidateRepo;
import com.eduonix.votingsystem.repository.CitizenRepo;

@Controller
public class VotingController {

	@Autowired
	private CitizenRepo citizenRepo;
	
	@Autowired
	private CandidateRepo candidateRepo;
	
	@RequestMapping("/")
	public String goToVote() {
		
		return "vote.html";
	}
	
	@RequestMapping("/checkIfVoted")
	public String checkIfVoted(@RequestParam String name,Model model) {
		
		Citizen citizen = citizenRepo.findByName(name);
		if(!citizen.isHasVoted()) {
			List<Candidate> candidates = candidateRepo.findAll();
			model.addAttribute("candidates",candidates);
			return "/performVote.html";
		}else {
			
			return "alreadyVoted.html";
		}
		
	}
}
