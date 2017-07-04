package com.uitgis.ubps.gdssquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uitgis.ubps.gdssquery.domain.Role;



@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRole(String role);

}