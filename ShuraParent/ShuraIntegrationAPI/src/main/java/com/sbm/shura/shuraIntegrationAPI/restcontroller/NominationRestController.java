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
	
	
}
