package com.project.dao;

import java.util.List;

import com.project.po.Phone;

public interface PhoneDAO {
	public void savePhone(Phone arg0);
	public void deletePhone(Phone arg0);
	public void updatePhone(Phone arg0);
	public Phone getPhoneById(Integer arg0);
	public List<Phone> getPhonesByHql(String hql);
	@SuppressWarnings("rawtypes")
	public List getList(String hql);
}
