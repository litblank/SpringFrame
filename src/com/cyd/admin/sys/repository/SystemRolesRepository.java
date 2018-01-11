/**
 * @author chenyd 
 * 2018年1月10日
 */
package cyd.admin.sys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cyd.admin.sys.entity.SystemRoles;


public interface SystemRolesRepository extends JpaRepository<SystemRoles, Long>, JpaSpecificationExecutor<SystemRoles>{
	
	@Query("select r.role from SystemUser u left join u.sysRoleList r where u.userName=?1")
	List<String> findRolesByUsername(String username);
}
