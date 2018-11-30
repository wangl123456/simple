package com.su.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.su.model.SysUser;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年11月20日下午5:06:39
* 创建描述：
* 
* 修 改 者：  
* 修改时间： 
* 修改描述： 
* 
* 审 核 者：
* 审核时间：
* 审核描述：
*
 */

public class CacheTest extends BaseMapperTest{
    
	@Test
	public void  testLlCache(){
		
		SqlSession sqlSession=getSqlSession();
		
		SysUser user1=null;
		
		try{
			
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			
			user1=userMapper.selectById(1L);
			
			//对当前获取的对象重新赋值
			user1.setUserName("New Name");
			//再次查询获取id相同的用户
			SysUser user2=userMapper.selectById(1L);
			
			//Assert.assertEquals ("New Name", user2 . getUserName());
			
			//Assert.assertEquals(user1 , user2) ;
		}finally{
			
			sqlSession.close();
		}
		//开启新的SqlSession
		System.out.println("开启新的SqlSession");
		
		sqlSession=getSqlSession();
		try{
			
         UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
         
         SysUser user2 = userMapper.selectById(1L);
         
         Assert.assertNotEquals ("New Name", user2.getUserName());
         
         Assert.assertNotEquals(user1 , user2); 
         
         userMapper.deleteById (2L); 
         
         SysUser user3 = userMapper.selectById(1L) ; 
         
         Assert.assertNotEquals(user2 , user3); 
         
		}finally{
			
			sqlSession.close();
		}
	}
}
