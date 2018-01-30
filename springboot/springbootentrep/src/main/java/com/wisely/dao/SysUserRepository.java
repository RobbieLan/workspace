package com.wisely.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisely.domain.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long>{
	
	SysUser findByUsername(String username);

}
