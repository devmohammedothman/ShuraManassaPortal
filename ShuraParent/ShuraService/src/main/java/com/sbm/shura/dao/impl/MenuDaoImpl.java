package com.sbm.shura.dao.impl;

import java.util.List;

import com.sbm.shura.dao.MenuDao;
import com.sbm.shura.entity.Menu;

public class MenuDaoImpl extends GenericDaoImpl<Menu> implements MenuDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuList() throws Exception {
		// TODO Auto-generated method stub
		return (List<Menu>)entityManager.createNamedQuery("Menu.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuListByUserName(String userName) throws Exception
	{
		return (List<Menu>)entityManager.createNamedQuery("Menu.findMenuListByUserName").getResultList();
	}

}
