package com.su.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年10月23日上午11:16:58
* 创建描述：
* 
* 修 改 者：  
* 修改时间： 
* 修改描述： 
* 
* 审 核 者：
* 审核时间：
* 审核描述：基础测试类
*
*/

public class BaseMapperTest {
	
     private static SqlSessionFactory sqlSessionFactory;
     
     @BeforeClass
     public static void init(){
    	 
    	 try {
    		 
    		 Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
    		 
    		 sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
    		 
    		 reader.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
     }
     
     public SqlSession getSqlSession(){
		
    	 return sqlSessionFactory.openSession();
     }
}
