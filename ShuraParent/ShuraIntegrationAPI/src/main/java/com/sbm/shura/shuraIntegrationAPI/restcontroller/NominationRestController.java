<<<<<<< HEAD
package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.shura.dto.BaseDTO;
import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.management.NominationManage;

@RestController
@RequestMapping("/api/nomination/")
@CrossOrigin("*")
public class NominationRestController {

	@Resource
	private NominationManage manage;
	
	@Resource
	private RestDTOProvider dtoProvider;
	
	@RequestMapping (value = "addwish", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> addUserWish(@RequestBody UserWishDTO userWishDto) throws Exception
	{
		return dtoProvider.addObj(manage.addUserWish(userWishDto));
	}
	
	
}
=======
package com.sbm.shura.shuraIntegrationAPI.restcontroller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.shura.dto.BaseDTO;
import com.sbm.shura.dto.UserWishDTO;
import com.sbm.shura.management.NominationManage;

@RestController
@RequestMapping("/api/nomination/")
@CrossOrigin("*")
public class NominationRestController {

	@Resource
	private NominationManage manage;
	
	@Resource
	private RestDTOProvider dtoProvider;
	
	@RequestMapping (value = "addwish", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> addUserWish(@RequestBody Map<String, Long> map) throws Exception
	{
		return dtoProvider.addObj(manage.addUserWish(map.get("userid"),map.get("committeeid"), map.get("wishOrder")));
	}
	
	
	@RequestMapping (value = "managerassignwish", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> managerAssignWish(@RequestBody List<UserWishDTO> list) throws Exception
	{
		try {
			String msg = manage.managerAssignUserWish(list);
			if (msg != null) {
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
}
>>>>>>> branch 'ftb-basestarterfeatures' of https://github.com/sbm-mohammedothman/ShuraManassaPortal.git
