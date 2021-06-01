package com.trainingvti.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trainingvti.entity.Group;

public interface IGroupRepository extends JpaRepository<Group, Short>, JpaSpecificationExecutor<Group>{
	public Group findByName(String name);
	public boolean existsByName(String name);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Group WHERE id IN(:ids)")
	public void deleteByIds(@Param("ids") List<Short> ids);
}
