package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.dto.MenuDTO;

public interface MenuService {

	MenuDTO addMenu(MenuDTO item)  throws BusinessException;

	List<MenuDTO> getMenuList()  throws BusinessException;
}
