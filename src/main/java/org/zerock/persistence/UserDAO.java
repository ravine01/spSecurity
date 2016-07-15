package org.zerock.persistence;

import org.zerock.domain.UserVO;

public interface UserDAO {

	public UserVO getUser(String userid)throws Exception;
}
