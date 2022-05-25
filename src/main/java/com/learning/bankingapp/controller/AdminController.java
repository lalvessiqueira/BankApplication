package com.learning.bankingapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.*;
//=======
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

//>>>>>>> Stashed changes

import com.learning.bankingapp.entity.Staff;
import com.learning.bankingapp.service.AdminService;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/staff")
	public List<Staff> getAllStaff(){
		return adminService.getAllStaff();
	}
	
	//Enable Staff
	@PostMapping("/enable/staff")
	public ResponseEntity<Object> enableStaff( @RequestBody Staff staff) {	
			
			try {
			Staff msg = adminService.enableStaff(staff);
			return ResponseEntity.ok(msg);
			}
			catch (Exception e) {
				return ResponseEntity.badRequest().body("Staff status not changed");
			}
	}
	
	//Logout
	@PostMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null){
	new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:/register";
	}

}

