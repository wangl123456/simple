package com.su.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.su.model.Country;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年10月22日上午9:59:44
* 创建描述：
* 
* 修 改 者：  在基本的mybatis中,session工厂可以使用sqlsessionFactoryBuilder来创建,而在mybatis-spring中,
* 修改时间： 使用sqlsessionFactoryBean来替换     
* 修改描述： 
* 
* 审 核 者：
* 审核时间：      一个JUnit4的单元测试用例执行顺序为：@BeforeClass -> @Before -> @Test -> @After -> @AfterClass; 
*           
* 审核描述：
*   @BeforeClass:在类中只会被执行一次         @Afterclass:所有测试用例执行完才执行一次
 */

public class CountryMapperTest {
	
   public static SqlSessionFactory sqlSessionFactory;
   
   @BeforeClass
   public static void init(){
	   try {
		   /**
		    * Resources 类为从类路径中加载资源
		    * Resources 类常用于以下几种情况：
		    * 从类路径加载 SQL Map 配置文件（如 sqlMap-config.xml）
		    * 从类路径加载 DAO Manager 配置文件（如 dao.xml）
		    * 从类路径加载各种.properties 文件
		    */
		   //通过Resources工具类将mybatis-config.xml配置文件读入reader
		   Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
		   
		   sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		   
		   reader.close();
		   
	} catch (IOException e) {
		
		e.printStackTrace();
	}
   }
   @Test
   public void testSelectAll(){
	   SqlSession sqlSession=sqlSessionFactory.openSession();
	   
	   try{
		   
		   List<Country> countryList=sqlSession.selectList("selectAll");
           
		   printCountryList(countryList);
	   }finally{
		   //关闭sqlSession
		   sqlSession.close();
	   }
   }
   public static void printCountryList(List<Country> countryList){
	   for (Country country : countryList) {
		System.out.printf("%-4d%4s%4s\n",country.getId(),country.getCountryname(),country.getCountrycode());
	  }
   }
}
