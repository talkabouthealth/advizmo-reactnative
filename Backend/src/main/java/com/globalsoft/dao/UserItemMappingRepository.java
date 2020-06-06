package com.globalsoft.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globalsoft.dto.models.UserItemCompositeId;
import com.globalsoft.dto.models.UserItemMapping;

@Repository
public interface UserItemMappingRepository extends JpaRepository<UserItemMapping, UserItemCompositeId>{
	List<UserItemMapping> findByUserItemCompositeId(UserItemCompositeId userItemCompositeId);
//	List<UserItemMapping> findByItemId(UserItemCompositeId. itemId);
//	List<UserItemMapping> findEmployeeByUserId( userId);
	@Query( value="select * from user_item_mapping where user_id = :id", nativeQuery = true)
	List<UserItemMapping> findByUserId(@Param("id") String userId);
	
	List<UserItemMapping> findByUserItemCompositeIdUserId(String userId);
}
