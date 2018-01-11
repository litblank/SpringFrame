package core.test.annotation;

/**
 * 
 * @author chenyd
 *
 */

public class User {
	
	@IsEmptyAnnotation
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
