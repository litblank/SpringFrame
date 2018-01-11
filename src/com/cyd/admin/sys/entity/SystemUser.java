package cyd.admin.sys.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 用户
 * @author chenyd
 * 2018年1月10日
 */
@Table(name = "cyd_sys_user")
@Entity
public class SystemUser {
	
	@Id
	@GeneratedValue(generator = "system_uuid")
	@GenericGenerator(name = "system_uuid", strategy = "uuid")
	private String id;
	@Column(name="user_name")
	private String userName;//不能重复
	@Column(name="create_time")
	private Date createTime;
	@Column(name="pass_word")
	private String passWord;
	@Column(name = "role_ids")
	private String roleIds;
	@Column
	private String locked;
	@Column
	private String salt;

	@ManyToMany(mappedBy = "sysUserList")
	private List<SystemRoles> sysRoleList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<SystemRoles> getSysRoleList() {
		return sysRoleList;
	}

	public void setSysRoleList(List<SystemRoles> sysRoleList) {
		this.sysRoleList = sysRoleList;
	}

	@Override
	public String toString() {
		return "SystemUser [id=" + id + ", userName=" + userName + ", createTime=" + createTime + ", passWorld="
				+ passWord + ", roleIds=" + roleIds + ", locked=" + locked + ", salt=" + salt + "]";
	}
	
}
