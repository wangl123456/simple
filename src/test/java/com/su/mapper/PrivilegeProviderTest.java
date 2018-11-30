package com.su.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.su.model.SysPrivilege;

import junit.framework.Assert;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年10月25日下午3:23:34
* 创建描述：
* 
* 修 改 者：  
* 修改时间： 
* 修改描述： 
* 
* 审 核 者：
* 审核时间：
* 审核描述：这个测试有错,估计是mybatis版本太低,需再次测试
*
 */

public class PrivilegeProviderTest extends BaseMapperTest{
	
	 @Test
     public void testSelectById(){
    	 
		 SqlSession sqlSession=getSqlSession();
		 
		 PrivilegeMapper privilegeMapper=sqlSession.getMapper(PrivilegeMapper.class);
		 
		 SysPrivilege sysPrivilege=privilegeMapper.selectById(1L);
		 
		 Assert.assertNotNull(sysPrivilege);
		 
		 Assert.assertEquals("用户管理", sysPrivilege.getPrivilegeName());
		 
		 try{
			 
		 }finally{
			 
			 sqlSession.close(); 
		 }
     }
}
