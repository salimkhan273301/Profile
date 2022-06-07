package com.profile.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.profile.model.Profile;
import com.profile.service.ProfileService;

@Controller
public class ProfileController {
	@Autowired
	private ProfileService ps;
	
	 @GetMapping("/")
	 public String viewHomePage(Model model) {
	        model.addAttribute("list", ps.getAllProfile());
	        return "index";
	    }
	 
	 @GetMapping("/showProfile")
	    public String showNewEmployeeForm(Model model) {
	        // create model attribute to bind form data
	        Profile profile = new Profile();
	        model.addAttribute("profile", profile);
	        return "form";
	    }

	    @PostMapping("/saveProfile")
	    public String saveEmployee(@ModelAttribute("profile") Profile profile) {
	        // save employee to database
	        ps.saveProfile(profile);
	        return "redirect:/";
	    }

	    @GetMapping("/formForUpdate/{id}")
	    public String FormForUpdate(@PathVariable(value = "id") int id, Model model) {

	        // get employee from the service
	        Profile profile = ps.getProfileById(id);

	        // set employee as a model attribute to pre-populate the form
	        model.addAttribute("profile", profile);
	        
	        return "update";
	    }
	    
		@PostMapping("/update")
		public String updateEmployee(@ModelAttribute Profile profile,HttpSession session) {
			ps.saveProfile(profile);
			session.setAttribute("msg", "Employee Data Updated Successfully...");
			return "redirect:/";
			
		}

	    @GetMapping("/deleteProfile/{id}")
	    public String deleteProfile(@PathVariable(value = "id") int id) {

	        // call delete employee method 
	        this.ps.deleteProfileById(id);
	        return "redirect:/";
	    }

}
