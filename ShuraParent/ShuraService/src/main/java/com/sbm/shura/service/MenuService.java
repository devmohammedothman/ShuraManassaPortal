package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.dto.MenuDTO;

public interface MenuService {

	MenuDTO addMenu(MenuDTO item) throws Exception;

	List<MenuDTO> getMenuList() throws Exception;
}
