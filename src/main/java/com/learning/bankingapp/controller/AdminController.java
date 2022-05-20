package com.learning.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.entity.Staff;
import com.learning.bankingapp.service.AdminService;
import com.learning.bankingapp.service.StaffService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/authenticate")
	public void Authenticate() {}
	
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
	

}
