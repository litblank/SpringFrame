package core.test.aop.beans;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Sensor {
	private int id;
	private String name;
	private Date time;
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
