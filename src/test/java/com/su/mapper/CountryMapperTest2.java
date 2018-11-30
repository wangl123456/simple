package com.su.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
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
* 修 改 者：  
* 修改时间：   
* 修改描述： 
* 
* 审 核 者：
* 审核时间：
*           
* 审核描述：
*   
*/

public class CountryMapperTest2 extends BaseMapperTest{
	
   @Test
   public void testSelectAll(){
	   
	   SqlSession sqlSession=getSqlSession();
	   
	   try{
		   
		   List<Country> countryList=sqlSession.selectList("com.su.mapper.CountryMapper.selectAll");
           
		   printCountryList(countryList);
	   }finally{
		   
		   sqlSession.close();
	   }
   }
   public static void printCountryList(List<Country> countryList){
	   for (Country country : countryList) {
		System.out.printf("%-4d%4s%4s\n",country.getId(),country.getCountryname(),country.getCountrycode());
	  }
   }
   
}
