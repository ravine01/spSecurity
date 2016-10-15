package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.zerock.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Inject
	private SqlSession session;
		
	@Override
	public UserVO getUser(String userid) throws Exception {
		
		logger.info("-----------------------getUSER");
		
		return session.selectOne("org.zerock.mapper.UserMapper.loginUser", userid);
		
	}

}
