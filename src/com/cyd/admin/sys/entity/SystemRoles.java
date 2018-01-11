package cyd.admin.sys.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * 角色表
 */
@Table(name = "cyd_sys_roles")
@Entity
public class SystemRoles {
	@Id
	@GeneratedValue(generator = "system_uuid")
	@GenericGenerator(name = "system_uuid", strategy = "uuid")
	private String id;
	// 角色名称
	@Column
	private String role;//不能重复
	// 角色描述
	@Column
	private String description;
	// 是否可用
	@Column
	private String avaible;
	// 角色对应的资源
	@ManyToMany
	@JoinTable(name = "sys_roles_resource", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "resources_id") })
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<SystemResources> sysResourcesList;

	@ManyToMany
	@JoinTable(name = "sys_user_roles", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private List<SystemUser> sysUserList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvaible() {
		return avaible;
	}

	public void setAvaible(String avaible) {
		this.avaible = avaible;
	}

	public List<SystemResources> getSysResourcesList() {
		return sysResourcesList;
	}

	public void setSysResourcesList(List<SystemResources> sysResourcesList) {
		this.sysResourcesList = sysResourcesList;
	}

	public List<SystemUser> getSysUserList() {
		return sysUserList;
	}

	public void setSysUserList(List<SystemUser> sysUserList) {
		this.sysUserList = sysUserList;
	}
	
	
}
