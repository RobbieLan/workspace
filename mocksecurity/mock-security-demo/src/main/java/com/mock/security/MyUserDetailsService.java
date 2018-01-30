/**
 * 
 */
package com.mock.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author zhailiang
 *
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
//	public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

	private Logger logger = LoggerFactory.getLogger(getClass());
//	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("表单登录用户名:" + username);
//		return new User(username, "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		
		//enabled:fake delete.  accountNonLockd:freeze an account.
		//return new User(username, "123456", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities)
//		return new User(username, "123456", true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		String password=passwordEncoder.encode("123456");
		logger.info("数据库的密码是:"+password);
		return new User(username, password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		//		return buildUser(username);
	}

//	@Override
//	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
//		logger.info("设计登录用户Id:" + userId);
//		return buildUser(userId);
//	}
//
//	private SocialUserDetails buildUser(String userId) {
//		// 根据用户名查找用户信息
//		//根据查找到的用户信息判断用户是否被冻结
//		String password = passwordEncoder.encode("123456");
//		logger.info("数据库密码是:"+password);
//		return new SocialUser(userId, password,
//				true, true, true, true,
//				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//	}

}
