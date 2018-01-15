package cyd.admin.sys.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 权限
 * 角色-权限-资源
 * @author chenyd
 * 2018年1月12日
 */
@Entity
@Table(name="cyd_sys_perms")
public class SystemPerms {
	
	@Id
	@GeneratedValue(generator = "system_uuid")
	@GenericGenerator(name = "system_uuid", strategy = "uuid")
	private String id;
	/**
	 * 权限编号
	 */
	@Column
	private String code;
	/**
	 * 权限名称
	 */
	@Column
	private String name;
	/**
	 * 父id
	 */
	@Column(name = "parent_id")
	private String parentId;
	@Column
	private Date date;
	/**
	 * 优先级
	 */
	@Column
	private String priority;
	@Column
	private String urlId;
	@Column
	private String url;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getUrlId() {
		return urlId;
	}
	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
