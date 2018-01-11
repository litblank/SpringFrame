/**
 * @author chenyd 
 * 2018年1月10日
 */
package cyd.admin.sys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cyd.admin.sys.entity.SystemResources;


public interface SystemResourcesRepository extends JpaRepository<SystemResources, Long>, JpaSpecificationExecutor<SystemResources>{
	
	@Query("select res.name from SystemUser u left join u.sysRoleList r left join r.sysResourcesList  res where u.userName=?1")
	List<String> findResourceByUsername(String username);
}
