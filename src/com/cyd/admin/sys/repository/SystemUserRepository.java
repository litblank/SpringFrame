/**
 * @author chenyd 
 * 2018年1月10日
 */
package cyd.admin.sys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cyd.admin.sys.entity.SystemUser;

public interface SystemUserRepository extends JpaRepository<SystemUser, Long>, JpaSpecificationExecutor<SystemUser> {

	SystemUser findByUserName(String userName);

	@Query(value="select b.name url,GROUP_CONCAT(CONCAT('\"',t.role,'\"')) roles from cyd_sys_roles t "
			+ "left join sys_roles_resource a on t.id=a.role_id "
			+ "left join cyd_sys_resources b on a.resources_id=b.id group by b.name",nativeQuery=true)
	List<Object[]> findIniLoad();
}
