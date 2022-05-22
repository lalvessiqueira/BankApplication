package com.learning.bankingapp.service;

import java.util.List;

import com.learning.bankingapp.entity.Admin;
import com.learning.bankingapp.entity.Staff;

public interface AdminService {
	
	public String security(Admin admin);
	public Staff createStaff(Staff staff);
	public List<Staff> getAllStaff();
	public Staff enableStaff( Staff staff);
}
