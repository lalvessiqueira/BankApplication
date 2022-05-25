package com.learning.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.*;
//=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//>>>>>>> Stashed changes

import com.learning.bankingapp.entity.Admin;
import com.learning.bankingapp.entity.Staff;
import com.learning.bankingapp.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	/*
	@PostMapping("/authenticate")
	public String Authenticate(@RequestBody Admin admin) {
		return adminService.security(admin);
	}
	
	@PostMapping("/staff")
	public ResponseEntity<Object> createStaff( @RequestBody Staff staff) {
		
			try {
				adminService.createStaff(staff);
				return ResponseEntity.accepted().body(staff);
				}
				catch(Exception e) {
					return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User Name in use");
				}
			
			
			
	}*/
	
	@GetMapping("/staff")
	public List<Staff> getAllStaff(){
		
		return adminService.getAllStaff();
		
	}
	
	@PostMapping("/enable/staff")
	public ResponseEntity<Object> enableStaff( @RequestBody Staff staff) {	
			
			try {
			Staff sta = adminService.enableStaff(staff);
			return ResponseEntity.accepted().body(sta);
			}
			catch (Exception e) {
				return ResponseEntity.badRequest().body("Staff status not changed");

			}
	}
	

}

