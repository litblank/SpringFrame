package cyd.admin.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import cyd.admin.sys.repository.SystemUserRepository;

public class ShiroFilterFactoryBeanExtend extends ShiroFilterFactoryBean {

	@Autowired
	private SystemUserRepository sysUserRepository;

	@Override
	public void setFilterChainDefinitions(String definitions) {
		// 数据库中获取权限，{/index.jsp=authc,onrole["admin2","admin"],
		// /abc.jsp=authc,onrole["admin2","admin"]}
		try {
			Map<String,String> map=new HashMap<>();
			List<Object[]> otherChains = sysUserRepository.findIniLoad();
			for(Object[] obj:otherChains)
			{
				Object[] objects = (Object[]) obj;
				map.put("/" + objects[0], "authc,onrole[" + objects[1] + "]");
			}
			
			Ini ini = new Ini();
			ini.load(definitions);
			Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
			if (CollectionUtils.isEmpty(section)) {
				section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
			}
			section.putAll(map);
			setFilterChainDefinitionMap(section);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
