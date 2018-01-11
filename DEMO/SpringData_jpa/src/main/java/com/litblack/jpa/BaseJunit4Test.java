package com.litblack.jpa;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring-config.xml" })
public class BaseJunit4Test {

	@Autowired
	private UserBeanRepository userRepository;
	
	/**
	 * 保存
	 */
	public void save_obj() {
		System.out.println(userRepository);
		for (int i = 0; i < 100; i++) {
			UserBean entity = new UserBean();
			entity.setUserName("user_" + i);
			entity.setCreateTime(new Date());
			userRepository.save(entity);
		}

	}
	/**
	 * 查询-所有
	 */
	public void get_ALL_obj(){
		List<UserBean> list=userRepository.findAll();
		for (int i = 0; i < list.size(); i++) {
			UserBean obj = list.get(i);
			System.out.println(obj.getCreateTime());
		}
	}
	/**
	 * 查询-one-obj,自定义接口
	 */
	public void get_one_obj(){
		UserBean obj = userRepository.findByUserName("user_1");
		System.out.println(obj.toString());
	}
	/**
	 * 根据JQPL查询，获取一个包含所有字段的OBJ
	 * 返回: 一个pojo 集合
	 */
	public void get_jqpl_obj(){
		List<UserBean> list=userRepository.find_Jpql_list_obj("user_2");
		for (int i = 0; i < list.size(); i++) {
			UserBean obj = list.get(i);
			System.out.println(obj.toString());
		}
	}
	/**
	 * 根据JQPL查询,获取一个字段，
	 * 返回：一个字段
	 */
	public void get_jqpl_onestr(){
		List<String> list=userRepository.find_Jpql_list_one("user_2");
		for (int i = 0; i < list.size(); i++) {
			String obj = list.get(i);
			System.out.println(obj.toString());
		}
	}
	/**
	 * 根据JQPL查询,一行数据，获取多个字段
	 * 返回：object 不是POJO,不是string[]。是Object[] 
	 * 注意：每个数据类型与POJO类型一致
	 */
	public void get_jqpl_morestr(){
		List<Object> list=userRepository.find_Jpql_list_morefield("user_2");
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			String username=(String) obj[0];
			Date date=(Date) obj[1];
			System.out.println(username+"\t"+date);
		}
	}
	/**
	 * JQPL  获取指定字段的多个POJO
	 */
	public void get_jqpl_pojo_morestr(){
		List<Object> list=userRepository.find_Jpql_list_pojo_morefield();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			String username=(String) obj[0];
			Date date=(Date) obj[1];
			System.out.println(username+"\t"+date);
		}
	}
	/**
	 * SQL  获取POJO的所有字段，必须是所有POJO的所有字段
	 */
	public void get_sql_pojo_allstr(){
		List<UserBean> list=userRepository.find_SQL_pojo();
		for (int i = 0; i < list.size(); i++) {
			UserBean obj = list.get(i);
			System.out.println(obj.toString());
		}
	}
	/**
	 * SQL  获取多表查询的字段,可用于多表查询，组成临时表
	 * 注意：每个数据类型与POJO类型一致
	 */
	public void get_sql_obj_morestr(){
		List<Object> list=userRepository.find_SQL_obj();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			String username=(String) obj[0];
			String name=(String) obj[1];
			System.out.println(username+"\t"+name);
		}
	}
	/**
	 * 分页查询,先排序后分页
	 * select user_name,name from cyd_sys_user,t_user order by user_name desc limit ?, ?
	 */
	public void get_sql_obj_morestr_page(){
		Sort sort=new Sort(Direction.DESC,"user_name");
		Pageable page=new PageRequest(2,10,sort);//第二页，每页10条
		Page<Object> p=userRepository.find_SQL_obj(page);
		List<Object> list=p.getContent();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			String username=(String) obj[0];
			String name=(String) obj[1];
			System.out.println(username+"\t"+name);
		}
	}
	/**
	 * 多条件查询,分页,排序
	 */
	public void get_sql_obj_morestr_(){
		Page<UserBean> p=userRepository.findAll(new Specification<UserBean>() {
			
			public Predicate toPredicate(Root<UserBean> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate stuNameLike = cb.like(root.<String> get("userName"), "%user_%");
                Order oderby =cb.desc(root.<String> get("userName"));
                if(null != stuNameLike) query.where(stuNameLike);
                query.orderBy(oderby);
				return stuNameLike;
			}
		},new PageRequest(0, 20));
		List<UserBean> list=p.getContent();
		for (int i = 0; i < list.size(); i++) {
			UserBean obj = list.get(i);
			System.out.println(obj.toString());
		}
	}
	
	/**
	 * 通用单个实体查询
	 * @param T
	 * @return
	 */
	public <T> Specification base_Specification(Class T){
		return new Specification<T>(){
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				List<Expression<Boolean>> expression=predicate.getExpressions();
				expression.add(cb.like(root.<String> get(""), ""));
				return predicate;
			}};
	}
	
}

