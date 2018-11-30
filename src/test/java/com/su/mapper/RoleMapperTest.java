package com.su.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.su.model.SysPrivilege;
import com.su.model.SysRole;

import junit.framework.Assert;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年10月25日上午10:42:34
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

public class RoleMapperTest extends BaseMapperTest{
    @Test
    public void testSelectById(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
        	
        	//SysRole role=roleMapper.selectById(1L);
    		
    		SysRole role=roleMapper.selectById2(1L);
        	
        	Assert.assertNotNull(role);
        	
        	Assert.assertEquals("管理员", role.getRoleName());
        	
    	}finally{
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testInsert(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
    		
    		SysRole sysRole=new SysRole();
    		
    		sysRole.setCreateBy(1120L);
    		
    		sysRole.setCreateTime(new Date());
    		
    		sysRole.setEnabled(32);
    		
    		sysRole.setId(4L);
    		
    		sysRole.setRoleName("zhangsan");
    		
    		//int result=roleMapper.insert(sysRole);
    		
    		//int result=roleMapper.insert2(sysRole);
    		
    		int result=roleMapper.insert3(sysRole);
    		
    		Assert.assertEquals("zhangsan", sysRole.getRoleName());
    		
    	}finally{
    		
    		sqlSession.rollback();
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testUpdateById(){
    	
    	SqlSession sqlSession=getSqlSession();
    			
    	try{
    		
    		RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
    		
    		SysRole sysRole=new SysRole();
    		
    		sysRole.setRoleName("lisi");
    		
    		sysRole.setCreateBy(2210L);
    		
    		sysRole.setCreateTime(new Date());
    		
    		sysRole.setId(2L);
    		
    		int result=roleMapper.updateById(sysRole);
    		
    		Assert.assertEquals(1, result);
    		
    	}finally{
    		
    		sqlSession.rollback();
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testdeleteById(){
    	SqlSession sqlSession=getSqlSession();
		
    	try{
    		
    		RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
    		
    		int result=roleMapper.deleteById(2L);
    		
    		Assert.assertEquals(1, result);
    		
    	}finally{
    		
    		sqlSession.rollback();
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testSelectAllRoleAndPrivileges(){
    	
    	SqlSession sqlsession=getSqlSession();
    	
    	try{
    		
    		RoleMapper roleMapper=sqlsession.getMapper(RoleMapper.class);
    		
    		List<SysRole> role=roleMapper.selectAllRoleAndPrivileges();
    		
    		for (SysRole sysRole : role) {
				
    			System.out.println("角色名:"+sysRole.getRoleName());
    			
    			for (SysPrivilege privilege : sysRole.getPrivilegeList()) {
					
    				System.out.println("权限名"+privilege.getPrivilegeName());
				}
			}
    	}finally{
    		
    		sqlsession.close();
    	}
    }
    @Test
    public void testL2Cache(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	SysRole role1=null;
    	
    	try{
    		
    		RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
    		
    		role1=roleMapper.selectById(1L);
    		
    		role1.setRoleName("New Name");
    		
    		SysRole role2=roleMapper.selectById(1L);
    		
    		Assert.assertEquals("New Name", role2.getRoleName());
    		
    		Assert.assertEquals(role1, role2);
    		
    	}finally{
    		
    		sqlSession.close();
    		
    	}
    	System.out.println("开启一个新的SqlSession");
    	
    	sqlSession=getSqlSession();
    	
    	try{
    		
    		RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
    		
    		SysRole role2=roleMapper.selectById(1L);
    		
            Assert.assertEquals("New Name", role2.getRoleName());
    		
    		//Assert.assertEquals(role1, role2);
    		
    		SysRole role3=roleMapper.selectById(1L);
    		
    		//Assert.assertEquals(role2, role3);
    	}finally{
    		
    		sqlSession.close();
    	}
    }
}
