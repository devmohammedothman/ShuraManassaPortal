package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.entity.Menu;

public interface MenuDao extends GenericDao<Menu> {

	Menu add(Menu item) throws RespositoryException;
	
	List<Menu> getMenuList() throws RespositoryException;
	
	
}
