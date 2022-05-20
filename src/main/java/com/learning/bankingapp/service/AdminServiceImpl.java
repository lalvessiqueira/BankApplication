package com.learning.bankingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.bankingapp.Repo.StaffRepo;
import com.learning.bankingapp.entity.Customer;
import com.learning.bankingapp.entity.Staff;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private StaffRepo staffRepo;

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

		Staff staff2 = staffRepo.getById(staff1.getUid());
		
//		staff2.setAuthorized(staff1.getAuthorized());
			
			return staffRepo.save(staff2);
	}
	
	

}
