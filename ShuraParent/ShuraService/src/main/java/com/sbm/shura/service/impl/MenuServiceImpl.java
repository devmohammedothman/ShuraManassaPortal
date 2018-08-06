package com.sbm.shura.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.shura.commonlib.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.shura.commonlib.exceptions.types.BusinessException;
import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.MenuDao;
import com.sbm.shura.dto.MenuDTO;
import com.sbm.shura.entity.Menu;
import com.sbm.shura.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl extends BasicServiceImpl<MenuDTO, Menu> implements MenuService {

	@Autowired
	private MenuDao dao;

	private Menu _menu = new Menu();

	@Override
	public MenuDTO addMenu(MenuDTO item) throws BusinessException {
		MenuDTO result = null;
		try {
		_menu = convertToEntity(_menu, item);
		_menu = dao.add(_menu);
		result = convertToDTO(_menu, item);
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

	@Override
	public List<MenuDTO> getMenuList() throws BusinessException {
		List<MenuDTO> result;
		try {
		List<Menu> menuListResult =  dao.getMenuList();
		List<MenuDTO> menuDtoList =  menuListResult.stream().
				map(item -> convertToDTO(item, new MenuDTO())).collect(Collectors.toList());
		result = menuDtoList;
		}catch (RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		}
		return result;
	}

}
