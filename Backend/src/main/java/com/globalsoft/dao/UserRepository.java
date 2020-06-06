package com.globalsoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalsoft.dto.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
