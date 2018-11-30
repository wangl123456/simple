package com.su.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.su.model.SysRole;
import com.su.model.SysUser;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年10月22日下午5:13:15
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

public interface UserMapper {
    //根据用户id查询用户信息
	SysUser selectById(Long id);
	//查询全部用户
	List<SysUser> selectAll();
	//根据用户ID获取角色信息
	List<SysRole> selectRolesByUserId(Long userId);
	//新增用户
	int insert(SysUser sysUser);
	//测试JDBC方式返回主键自增的值  新增用户－使用 useGeneratedKeys 方式
	int insert2(SysUser sysUser);
	//新增用户使用selectKey方式
	int insert3(SysUser sysUser);
	//根据主键更新
	int updateById(SysUser sysUser);
	//根据主键删除
	int deleteById(Long id);
	//根据用户的id和角色的enabled状态来查询用户的角色
	List<SysRole> selectRolesByUserIdAndRoleEnable(@Param("userId")Long userId,@Param("enabled")Integer enabled);
    //测试动态sql OGNL  查询用户信息
	List<SysUser> selectByUser(SysUser sysUser); 
	//测试update中if
	int updateByIdSelective(SysUser sysuser);
	//测试insert中动态使用if
	int insert5(SysUser sysUser);
	//根据用户id或用户名查询
	SysUser selectByIdOrUserName(SysUser sysUser);
	//测试where标签的用法
	List<SysUser> selectByUser2(SysUser sysUser);
	//测试set标签用法
	int updateByIdSelective2(SysUser sysuser); 
	//测试foreach 实现in集合   根据用户id集合查询
	List<SysUser> selectByIdLit(List<Long> idList);
	//批量插入用户信息
	int inertList(List<SysUser> userList);
	//foreach实现动态UPDATE 
	int updateByMap(Map<String,Object> map);
	//根据用户id获取用户信息和用户的角色信息
	SysUser  selectUserAndRoleById(Long id);
	//根据用户id获取用户信息和用户的角色信息
	SysUser selectUserAndRoleById2 (Long id);
	
	SysUser selectUserAndRoleByIdSelect(Long id);
	//获取所有用户以及对应的所有角色
	List<SysUser> selectAllUserAndRoles();
}
