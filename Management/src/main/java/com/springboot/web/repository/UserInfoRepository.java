package com.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.modal.Userinfo;

public interface UserInfoRepository extends JpaRepository<Userinfo,Long>{
	
	

}
