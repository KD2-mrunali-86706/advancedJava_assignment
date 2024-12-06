package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

import dao.CandidateDao;
import dao.CandidateDaoImpl;
import entities.Candidate;

public class CandidateListBean {
	private List<Candidate> candidate;

	public CandidateListBean() {
		this.candidate = new ArrayList<Candidate>();

	}

	public CandidateListBean(List<Candidate> candidate) {
		
		this.candidate = candidate;
	}

	public List<Candidate> getCandidate() {
		return candidate;
	}

	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}
	
	public void fetchcandidate() {
		try(CandidateDao canDao=new CandidateDaoImpl()){
			this.candidate=canDao.findAll();
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
		
	}

}
