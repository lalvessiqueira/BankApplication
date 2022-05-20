package com.learning.bankingapp.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.learning.bankingapp.entity.Staff;

public interface AdminService {
	public Staff createStaff(Staff staff);
	public List<Staff> getAllStaff();
	public Staff enableStaff( Staff staff);
}
