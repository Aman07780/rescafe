package com.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.modal.User;

public interface UserRepo extends JpaRepository<User,Long>{

}
