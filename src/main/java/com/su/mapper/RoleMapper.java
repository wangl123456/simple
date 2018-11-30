package com.su.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.su.model.SysRole;

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
* 修改描述： insert,update,delete,select注解方法测试
* 
* 审 核 者：
* 审核时间：
* 审核描述：
*
 */
@CacheNamespaceRef(RoleMapper.class) 
public interface RoleMapper {
    @Select({"select id,role_name roleName,enabled,create_by createBy,create_time createTime "
    		+ "from sys_role where id=#{id}"})
	SysRole selectById(Long Id);
    
    @Results({
    	      @Result(property="id",column="id",id=true),
              @Result(property="roleName",column="role_name"),
              @Result(property="enabled",column="enabled"),
              @Result(property="createBy",column="create_by"),
              @Result(property="createTime",column="create_time"),
            })
    @Select({"select id,role_name,enabled,create_by,create_time from sys_role where id=#{id}"})
    SysRole selectById2(Long id);
    
    //不需要返回主键
    @Insert({"insert into sys_role(id,role_name,enabled,create_by,create_time)"
    		+ "values(#{id},#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    int insert(SysRole sysRole);
    
    //返回自增主键
    
    @Insert({"insert into sys_role(role_name,enabled,create_by,create_time)"
    		+ "values(#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert2(SysRole sysRole);
    
    //返回非自增主键
    @Insert({"insert into sys_role(role_name,enabled,create_by,create_time)"
    		+ "values(#{roleName},#{enabled},#{createBy},#{createTime,jdbcType=TIMESTAMP})"})
    @SelectKey(statement="SELECT LAST_INSERT_ID()",keyProperty="id",resultType=Long.class,before=false)
    int insert3(SysRole sysRole);
    
    @Update({"update sys_role set role_name=#{roleName},create_by=#{createBy},create_time=#{createTime,jdbcType=TIMESTAMP}"
    		+ " where id=#{id}"})
    int updateById(SysRole sysRole);
    
    @Delete("delete from sys_role where id=#{id}")
    int deleteById(Long id);
    
    List<SysRole> selectAllRoleAndPrivileges();
    
}
