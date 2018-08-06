package com.sbm.shura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.shura.commonlib.exceptions.types.RespositoryException;
import com.sbm.shura.dao.UserDao;
import com.sbm.shura.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	User user = null;
    	try {
    	user = userDao.findByEmail(email);
    	}catch(RespositoryException e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(e.getMessage());
		}
		catch(Exception e1) {
			e1.printStackTrace();
			throw new UsernameNotFoundException(e1.getMessage());
	    	}
        return user;
    }
}