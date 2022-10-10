package com.coderscampus.HotStonePOS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.HotStonePOS.domain.Address;
import com.coderscampus.HotStonePOS.domain.Customer;
import com.coderscampus.HotStonePOS.repository.AddressRepository;
import com.coderscampus.HotStonePOS.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository custRepo;

	@Autowired
	AddressRepository addRepo;

	public Customer findByPhone(String phone) {
		return custRepo.findByPhone(phone);
	}

	public Customer findById(Long id) {
		return custRepo.findById(id).orElse(null);

	}

	public void save(Customer cust) {	
		if(cust != null) {
			setAddressToCustomer(cust, new Address());
		}
	}

	public Address setAddressToCustomer(Customer cust, Address address) {
		address.setAddressLine1(cust.getAddress().getAddressLine1());
		address.setAddressLine2(cust.getAddress().getAddressLine2());
		address.setCity(cust.getAddress().getCity());
		address.setRegion(cust.getAddress().getRegion());
		address.setCountry(cust.getAddress().getCountry());
		address.setZipCode(cust.getAddress().getZipCode());
		address.setCustId(cust.getCustId());
		address.setCust(cust);
		cust.setAddress(address);
		return addRepo.save(address);
	}
}
