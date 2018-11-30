package com.su.mapper;


import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.su.model.SysPrivilege;
import com.su.model.SysRole;
import com.su.model.SysUser;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年10月23日下午1:34:17
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

public class UserMapperTest extends BaseMapperTest{
    @Test
	public void testSelectById(){
		
		SqlSession sqlSession=getSqlSession();
		
	try{
		//获取userMapper接口
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		
		SysUser user=userMapper.selectById(1L);
		//user不为空
		Assert.assertNotNull(user);
		//UserName=admin
		Assert.assertEquals("admin", user.getUserName());
		
	 }finally{
		 
		sqlSession.close();
     }
  }
    @Test
    public void testSelectAll(){
    	
    	SqlSession sqlSession=getSqlSession();
    try{
    	//获取userMapper接口
    	UserMapper user=sqlSession.getMapper(UserMapper.class);
    	
    	List<SysUser> sysUser=user.selectAll();
    	//user不为空
    	Assert.assertNotNull(sysUser);
    	
    	Assert.assertTrue(sysUser.size()>0);
    }finally{
    	sqlSession.close();
    }
  }
    @Test
    public void selectRolesByUserId(){
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		List<SysRole> role=userMapper.selectRolesByUserId(1L);
    		
    		Assert.assertNotNull(role);
        	
        	Assert.assertTrue(role.size()>0);
        	
    	}finally{
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testSelectRoleByUserId(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    	    List<SysRole> sysRole=userMapper.selectRolesByUserId(1L);
    	    
            Assert.assertNotNull(sysRole);
        	
        	Assert.assertTrue(sysRole.size()>0);
    	}finally{
    		sqlSession.close();
    	}
    }
    @Test
    public void testInsert(){
    	
    	SqlSession sqlsession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlsession.getMapper(UserMapper.class);
    		//创建一个user对象
    		SysUser user=new SysUser();
    		
    		user.setUserName("test1");
    		
    		user.setUserPassword("123456");
    		
    		user.setUserEmail("test@mybatis.su");
    		
    		user.setUserInfo("test info");
    		
    		user.setHeadImg(new byte[]{1,2,3});
    		
    		user.setCreateTime(new Date());
    		
    		//int tatol=userMapper.insert(user);
    		
    		int tatol=userMapper.insert5(user);
    		
    		Assert.assertEquals(1, tatol);
    		
    		//Assert.assertNull(user.getId());
    		
    	}finally{
    		/**
    		 * 为了不影响其它设置,这里选择回滚,由于默认的SqlSessionFactory.openSession()是不自动提交的
    		 * 因此不手动commit也不会提交到数据库
    		 */
    		sqlsession.rollback();
    		
    		sqlsession.close();
    	}
    }
    @Test
    public void testInsert2(){
    	SqlSession sqlsession=getSqlSession();
    	
    try{	
    	UserMapper userMapper=sqlsession.getMapper(UserMapper.class);
    	
    	SysUser user=new SysUser();
    	
    	user.setUserName("test ");
    	
    	user.setUserPassword ("123456"); 
    	
    	user.setUserEmail ("test@mybatis.tk") ; 
    	
    	user.setUserInfo ("test info"); 
    	
    	user.setHeadImg(new byte[] {1 , 2 , 3}); 
    	
    	user.setCreateTime(new Date()) ; 
    	
    	int result=userMapper.insert2(user);
    	
    	//只插入一条数据
    	Assert.assertEquals(1, result);
    	//因为id回写,所有ID不为空
    	Assert.assertNotNull(user.getId()); 
    	
       }finally{
    	   
    	   sqlsession.rollback();
    	   
    	   sqlsession.close();
    	   
    	}
    }
    @Test
    public void testUpdateById(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    	
    	SysUser sysUser=userMapper.selectById(1L);
    	
    	Assert.assertEquals("admin", sysUser.getUserName());
    	
    	sysUser.setUserName("admin_test");
    	
    	sysUser.setUserEmail("test@mybatis.sg");
    	
    	int result=userMapper.updateById(sysUser);
    	
    	Assert.assertEquals(1, result);
    	
    	SysUser user=userMapper.selectById(1L);
    	
    	Assert.assertEquals("admin_test", user.getUserName());
    	
    	try{
    		
    	}finally{
    		sqlSession.rollback();
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testDeleteById(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		SysUser sysUser=userMapper.selectById(1L);
    		
    		Assert.assertNotNull(sysUser);
    		
    		Assert.assertEquals(1, userMapper.deleteById(1L));
    		
    		Assert.assertNull(userMapper.selectById(1L));
    		
    		
    		
    		int result=userMapper.deleteById(1L);
    	}finally{
    		
    		sqlSession.rollback();
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testSelectRolesByUserIdAndRoleEnable(){
    	
		SqlSession sqlSession=getSqlSession();
		
		try{ 
			
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			
			List<SysRole> roleList=userMapper.selectRolesByUserIdAndRoleEnable(1L, 1);
			
			Assert.assertNotNull(roleList);
			
			Assert.assertTrue(roleList.size()>0);
			
		}finally{
			
			sqlSession.close();
		}
		
    }
    public void testMyMapperProxy(){
    	
       SqlSession sqlSession=getSqlSession();
		
		try{ 
			//获取usermapper接口
			MyMapperProxy myMapperProxy=new MyMapperProxy(UserMapper.class,sqlSession);
			
			UserMapper userMapper=(UserMapper) Proxy.newProxyInstance(Thread . currentThread() . getContextClassLoader(),new Class[]{UserMapper.class}, myMapperProxy);
			//调 sele ctAll
			List<SysUser> user= userMapper.selectAll(); 
		}finally{
			
			sqlSession.close();
		}
    }
    @Test
    public void testSelectByUser(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		//只查询用户名时
    		SysUser sysUser=new SysUser();
    		
    		sysUser.setUserName("ad");
    		
    		List<SysUser> user=userMapper.selectByUser2(sysUser);
    		
    		Assert.assertTrue(user.size()>0);

    		//只查询密码时
    		sysUser=new SysUser();
    		
    		sysUser.setUserPassword("123456");
    		
            List<SysUser> userList=userMapper.selectByUser(sysUser);
    		
    		Assert.assertTrue(userList.size()>0);

    		//用户名,密码都查询时
    		
    		sysUser=new SysUser();
    		
    		sysUser.setUserName("bc");
    		
    		sysUser.setUserPassword("123456");
    		
            List<SysUser> userLists=userMapper.selectByUser(sysUser);
    		
    		Assert.assertTrue(userLists.size()==0);
    		
    	}finally{
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testUpdateByIdSelective(){
         
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		SysUser sysuser=new SysUser();
    		
    		sysuser.setId(1L);
    		
    		sysuser.setUserEmail("test@mybatis.tk");
    		
    		int result=userMapper.updateByIdSelective2(sysuser);
    		
    		Assert.assertEquals(1, result);
    		
    		SysUser user=userMapper.selectById(1L);
    		
    		Assert.assertEquals("admin", user.getUserName());
    		
    		Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
    		
    	}finally{
    		
    		sqlSession.rollback();
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void  testSelectByidOrUserName(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		//只查询用户时
    		SysUser sysUser=new SysUser();
    		
    		sysUser.setId(1L);
    		
    		sysUser.setUserName("admin");
    		
    		SysUser user=userMapper.selectByIdOrUserName(sysUser);
    		
    		Assert.assertNotNull(user);
    		
    		//当没有id时
    		sysUser.setId(null);
    		
    		user=userMapper.selectByIdOrUserName(sysUser);
    		
    		Assert.assertNotNull(user);
    		//当id和name都为空时
    		sysUser.setUserName(null);
    		
            user=userMapper.selectByIdOrUserName(sysUser);
    		
    		//Assert.assertNotNull(user);
    		
    	}finally{
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testSelectByIdLit(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		List<Long> idList = new ArrayList<Long>();
    		
    		idList.add(1L); 
    		
    		idList.add(1001L); 
    		
    		List<SysUser> userList=userMapper.selectByIdLit(idList);
    		
    		Assert.assertEquals(2 , userList.size()); 
    	}finally{
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testInsertList(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper UserMapper=sqlSession.getMapper(UserMapper.class);
    		
    		List<SysUser>  userList=new ArrayList<SysUser>();
    		
    		for(int i=1;i<=2;i++){
    			
    			SysUser  sysUser=new SysUser();
    			
    			sysUser.setUserName("test"+i);
    			
    			sysUser.setUserPassword("123456");
    			
    			sysUser.setUserEmail("test@mybatis.tk");
    			
    			userList.add(sysUser);
    		}
    		
    		int result=UserMapper.inertList(userList);
    		
    		Assert.assertEquals(2, result);
    	}finally{
    		
    		sqlSession.rollback();
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testUpdateByMap(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		Map<String,Object> map=new HashMap<String,Object>();
    		
    		map.put("id", 1L);
    		
    		map.put("user_email", "test@mybatis.tk");
    		
    		map.put("user_password", "12345678");
    		
    		userMapper.updateByMap(map);
    		//根据当前id查询修改后的数据
    		SysUser user=userMapper.selectById(1L);
    		
    		Assert.assertEquals("test@mybatis.tk", user.getUserEmail());
    		
    	}finally{
    		
    		sqlSession.rollback();
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void SelectUserAndRoleById(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		SysUser sysUser=userMapper.selectUserAndRoleById(1001L);
    		
    		Assert.assertNotNull(sysUser);
    		
    		Assert.assertNotNull(sysUser.getRole());
    	}finally{
    		
    		sqlSession.close();
    		
    	}
    }  	
    @Test
    public void selectUserAndRoleById2(){
     
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		SysUser sysUser=userMapper.selectUserAndRoleById2(1001L);
    		
    		Assert.assertNotNull(sysUser);
    		
    		Assert.assertNotNull(sysUser.getRole());
    	}finally{
    		
    		sqlSession.close();
    		
    	}
    }
    @Test
    public void  testSelectUserAndRoleByIdSelect(){
    	
    	SqlSession sqlsession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlsession.getMapper(UserMapper.class);
    		
    		SysUser user=userMapper.selectUserAndRoleByIdSelect(1001L);
    		
    		Assert.assertNotNull(user);
    		
    		System.out.println("調用user.equals(null )");
    		
    		//user.equals(null);
    		
    		System.out.println("調用getRole()");
    		
    		Assert.assertNotNull(user.getRole());
    	}finally{
    		
    		sqlsession.close();
    		
    	}
    }
    @Test
    public void testSelectAllUserAndRoles(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		List<SysUser> sysUserList=userMapper.selectAllUserAndRoles();
    		
    		System.out.println("用户数:"+sysUserList.size());
    		
    		for (SysUser user : sysUserList) {
				
    			System.out.println("用户名"+user.getUserName());
    			
    			for (SysRole role : user.getRoleList()) {
    				
					System.out.println("角色名:"+role.getRoleName());
					
					for (SysPrivilege privilege : role.getPrivilegeList()) {
						
						System.out.println("权限名"+privilege.getPrivilegeName());
					}
				}
			}
    	}finally{
    		
    		sqlSession.close();
    	}
    }
    @Test
    public void testDirtyData(){
    	
    	SqlSession sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		SysUser user= userMapper.selectUserAndRoleById(1001L) ; 
    		
    		Assert.assertEquals ("普通用户",user.getRole().getRoleName()); 
    		
    		System.out.println("角色名:"+user.getRole().getRoleName());
    	}finally{
    		
    		sqlSession.close();
    		
    	}
    	System.out.println("开启一个新的sqlSession2");
    	
        sqlSession=getSqlSession();
   	
   	try{
   		
   		RoleMapper roleMapper = sqlSession.getMapper (RoleMapper.class) ; 
   		
   		SysRole role=roleMapper.selectById(2L);
   		
   		role.setRoleName("脏数据");
   		
   		roleMapper.updateById(role);
   		
   	    sqlSession.commit();
   	}finally{
   		
   		sqlSession.close();
   		
   	}
    	System.out.println("开启一个新的sqlSession3");
    	
         sqlSession=getSqlSession();
    	
    	try{
    		
    		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
    		
    		RoleMapper roleMapper = sqlSession.getMapper (RoleMapper.class) ; 
    		
    		SysUser user= userMapper.selectUserAndRoleById(1001L) ; 
    		
    		SysRole role=roleMapper.selectById(2L);
    		
    	    Assert.assertEquals ("普通用户",user.getRole().getRoleName()); 
    		
    		Assert.assertEquals ("脏数据",role.getRoleName());

    		System.out.println("角色名:"+user.getRole().getRoleName());
    		
    		role.setRoleName("普通用户");
    		
    		roleMapper.updateById(role);
    		
    		sqlSession.commit();
    	}finally{
    		
    		sqlSession.close();
    		
    	}
    }
}
