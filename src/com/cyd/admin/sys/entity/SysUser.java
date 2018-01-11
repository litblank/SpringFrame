package cyd.admin.sys.entity;

import java.util.Date;

import core.utils.Entity;

public class SysUser extends Entity{
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
	public Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
