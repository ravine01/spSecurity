package org.zerock.security;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.domain.UserVO;
import org.zerock.persistence.UserDAO;
import org.zerock.security.SecurityUserVO;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Inject
	private UserDAO dao;	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		
		UserVO vo = new UserVO();
		vo.setUserid("admin");
		vo.setUserpw("root123");
		vo.setUserName("Hong Gil Dong");
		vo.setRole("ADMIN");
		
//		UserVO vo;
//		try {
//			vo = dao.getUser(userId);
//			SecurityUserVO securityUser = new SecurityUserVO(vo);
//			return securityUser;
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return new SecurityUserVO(vo);
	}
	


}
