package core.test.velocity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * velocity 生成代码，还有其他的功能，email模板，自动生成代码，web前后台分离，转XML模板
 * @author chenyd
 * 2017年10月17日
 */
public class hellovelocity {
	
	public static void main(String[] args) throws IOException {
	    // 初始化模板引擎
		VelocityEngine ve = new VelocityEngine();
 	    ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
 	    ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	    ve.init();
	    // 获取模板文件
	    Template t = ve.getTemplate("core/test/velocity/hellovelocity.vm");
	    // 设置变量
	    VelocityContext ctx = new VelocityContext();
	    ctx.put("name", "Velocity");
	    ctx.put("flag", "true");
	    List list = new ArrayList();
	    list.add("1");
	    list.add("2");
	    ctx.put("list", list);
	    // 输出
	    File f=new File("E:/cyd/poject/maven/MSpringFrame/src/core/test/velocity/hellovelocity.txt");
	    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
	    t.merge(ctx,bw);
	    System.out.println(bw.toString());
	    bw.flush();
	    bw.close();
	}
}
