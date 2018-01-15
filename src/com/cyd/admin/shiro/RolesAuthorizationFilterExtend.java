package cyd.admin.shiro;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

/**
 * 通过验证角色
 * @author chenyd
 * 2017年11月21日
 */
public class RolesAuthorizationFilterExtend extends RolesAuthorizationFilter{
	
	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
		
		System.out.println(RolesAuthorizationFilterExtend.class.toString());
		
        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;
        
        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }
        System.out.println("需要的角色:"+Arrays.toString(rolesArray));
        Set<String> roles = CollectionUtils.asSet(rolesArray);
        boolean flag=false;
        for(String role: roles){
        	if(subject.hasRole(role)){
        		flag=true;
        		break;
        	}
        }
        return flag;
    }
}
