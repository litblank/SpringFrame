package core.test.annotation;

public class AnnotationTest {

	public static void main(String[] args) {
		User advertise = new User();  
        advertise.setName("a");  
        System.out.println(AnnotationDealUtil.validate(advertise));
	}

}
