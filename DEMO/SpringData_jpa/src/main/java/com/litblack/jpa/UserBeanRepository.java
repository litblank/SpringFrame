package com.litblack.jpa;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
/**
 * SQL��JPQL��ѯ
 * ���أ�list<POJO>,list<Stinrg>,list<Object>,Page<Object>
 * ���ܷ���MAP
 * @author chenyd
 * 2018��1��10��
 */
public interface UserBeanRepository  extends JpaRepository<UserBean, Long>, JpaSpecificationExecutor<UserBean>{
	
	UserBean findByUserName(String username);
	
	@Query("from UserBean where userName =?1")
	List<UserBean> find_Jpql_list_obj(String username);

	
	@Query("select userName from UserBean where userName =?1")
	List<String> find_Jpql_list_one(String username);
	
	@Query("select userName,createTime from UserBean where userName =?1")
	List<Object> find_Jpql_list_morefield(String username);
	
	@Query("select userName,createTime from UserBean ")
	List<Object> find_Jpql_list_pojo_morefield();
	
	/**
	 * ����������ΪPOJO������������POJO�������ֶΣ�����ֻ��ѯĳ���ֶ�
	 */
	@Query(value="select * from cyd_sys_user",nativeQuery=true)
	List<UserBean> find_SQL_pojo();
	
	@Query(value="select user_name,name from cyd_sys_user,t_user",nativeQuery=true)
	List<Object> find_SQL_obj();
	
	/**
	 * ��ҳ��Ҫ #pageable ��ʶ
	 * NativeJpaQuery
	 * @param pageable
	 * @return
	 */
	@Query(value="select user_name,name from cyd_sys_user,t_user  /*#pageable*/  ",countQuery="select count(*) from cyd_sys_user,t_user",nativeQuery=true)
	Page<Object> find_SQL_obj(Pageable pageable);
}
