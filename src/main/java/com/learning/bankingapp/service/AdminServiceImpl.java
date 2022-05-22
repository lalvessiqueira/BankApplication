package com.learning.bankingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.bankingapp.Repo.AdminRepo;
import com.learning.bankingapp.Repo.StaffRepo;
import com.learning.bankingapp.entity.Admin;
import com.learning.bankingapp.entity.Staff;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private StaffRepo staffRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public String security(Admin admin1) {
		
		Admin admin2 = adminRepo.getById(admin1.getUid());
		
		if (admin2.getUsername().equals(admin1.getUsername()) &&
				admin2.getPassword().equals(admin1.getPassword()) ) {
			return "good to go";
		}	
		else
			return "Not correct";
	}

	@Override
	public Staff createStaff(Staff staff) {
		
		return staffRepo.save(staff);
	}

	@Override
	public List<Staff> getAllStaff() {

		return staffRepo.findAll();
	}

	@Override
	public Staff enableStaff(Staff staff1) {

		Staff staff2 = staffRepo.findBystaffId(staff1.getStaffId());
		
		staff2.setStatus(staff1.getStatus());
			
			return staffRepo.save(staff2);
	}
	
	

}
