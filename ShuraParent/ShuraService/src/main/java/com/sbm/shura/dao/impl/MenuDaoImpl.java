package com.sbm.shura.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.MenuDao;
import com.sbm.shura.entity.Menu;

@Repository
public class MenuDaoImpl extends GenericDaoImpl<Menu> implements MenuDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuList() throws RespositoryException {
		List<Menu> menus;
		try {
			menus = (List<Menu>)entityManager.createNamedQuery("Menu.findAll").getResultList();
		}catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		}
		return menus;
	}
	
	@Override
	public Menu add(Menu item) throws RespositoryException {
		return persist(item);
	}
	

}
