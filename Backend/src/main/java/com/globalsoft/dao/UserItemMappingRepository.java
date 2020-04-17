package com.globalsoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalsoft.dto.models.UserItemMapping;

@Repository
public interface UserItemMappingRepository extends JpaRepository<UserItemMapping, String>{

}
