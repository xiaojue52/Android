package com.project.service.impl;

import java.util.List;

import com.project.dao.PhoneDAO;
import com.project.po.Phone;
import com.project.service.PhoneService;

public class PhoneServiceImpl implements PhoneService {

	private PhoneDAO phoneDAO;
	
	public void setPhoneDAO(PhoneDAO phoneDAO) {
		this.phoneDAO = phoneDAO;
	}

	@Override
	public void savePhone(Phone arg0) {
		// TODO Auto-generated method stub
		phoneDAO.savePhone(arg0);
	}

	@Override
	public void deletePhone(Phone arg0) {
		// TODO Auto-generated method stub
		phoneDAO.deletePhone(arg0);
	}

	@Override
	public void updatePhone(Phone arg0) {
		// TODO Auto-generated method stub
		phoneDAO.updatePhone(arg0);
	}

	@Override
	public Phone getPhoneById(Integer arg0) {
		// TODO Auto-generated method stub
		return phoneDAO.getPhoneById(arg0);
	}

	@Override
	public List<Phone> getPhonesByHql(String hql) {
		// TODO Auto-generated method stub
		return phoneDAO.getPhonesByHql(hql);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getList(String hql) {
		// TODO Auto-generated method stub
		return this.phoneDAO.getList(hql);
	}

}
