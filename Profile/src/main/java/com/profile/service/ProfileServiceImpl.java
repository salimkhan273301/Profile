package com.profile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profile.dao.ProfileRepo;
import com.profile.model.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepo pr;
	public Object getAllProfile() {
		
		return pr.findAll();
	}
	@Override
	 public void saveProfile(Profile p) {
	        this.pr.save(p);
	    }

	    @Override
	    public Profile getProfileById(int id) {
	        Optional < Profile > optional = pr.findById(id);
	        Profile p = null;
	        if (optional.isPresent()) {
	            p = optional.get();
	        } else {
	            throw new RuntimeException(" Profile not found for id :: " + id);
	        }
	        return p;
	    }

	    @Override
	    public void deleteProfileById(int id) {
	        this.pr.deleteById(id);
	    }

		
		

}
