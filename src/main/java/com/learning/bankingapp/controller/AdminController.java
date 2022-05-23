package com.learning.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.learning.bankingapp.entity.Admin;
import com.learning.bankingapp.entity.Staff;
import com.learning.bankingapp.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/authenticate")
	public String Authenticate(@RequestBody Admin admin) {
		return adminService.security(admin);
	}
	
	@PostMapping("/staff")
	public Staff createStaff( @RequestBody Staff staff) {

			return adminService.createStaff(staff);
	}
	
	@GetMapping("/staff")
	public List<Staff> getAllStaff(){
		
		return adminService.getAllStaff();
		
	}
	
	@PostMapping("/enable/staff")
	public Staff enableStaff( @RequestBody Staff staff) {

			return adminService.enableStaff(staff);
	}
	// IF ERROR MESSAGE SHOULD BE STAFF NOT CHANGED
	

}
