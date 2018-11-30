package com.su.generator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年11月7日下午5:35:33
* 创建描述：
* 
* 修 改 者：  
* 修改时间： 
* 修改描述： 读取MBG配置生成的代码
* 
* 审 核 者：
* 审核时间：
* 审核描述：
*
 */

public class Generator {
	
     public static void main(String[] args) throws Exception {
		 //MBG执行过程中生成的警告信息
    	 List<String> warnings=new ArrayList<String>();
    	 //当生成的代码重复时,覆盖原码
    	 boolean overwrite=true;
    	 //读取MBG配置文件
    	 InputStream is=Generator.class.getResourceAsStream("generatorConfig.xml");
    	 
    	 ConfigurationParser cp=new ConfigurationParser(warnings);
    	 
    	 Configuration config=cp.parseConfiguration(is);
    	 
    	 is.close();
    	 
    	 DefaultShellCallback callback=new DefaultShellCallback(overwrite);
    	 //创建MBG
    	 MyBatisGenerator myBatisGenerator=new MyBatisGenerator(config,callback,warnings);
    	 //执行生成的代码
    	 myBatisGenerator.generate(null);
    	 //输出警告信息
    	 for (String warning : warnings) {
			
    		 System.out.println(warning);
		}
	}
}
