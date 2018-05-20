package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.entity.Menu;

public interface MenuDao extends GenericDao<Menu> {

	
	List<Menu> getMenuList() throws Exception;
	
	List<Menu> getMenuListByUserName(String userName) throws Exception;
}
