package com.su.mapper;

import org.apache.ibatis.jdbc.SQL;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年10月25日下午3:11:00
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

public class PrivilegeProvider {
	
    public String selectById(final Long id){
    	
		return new SQL(){
			{
				SELECT("id, privilege_name, privilege_url");
				FROM("sys_privilege");
				WHERE("id=#{id}");
			}
		}.toString();
    	
    }
    
    public String selectById2(final Long id){
		
    	return "select id,privilege_name,privilege_url from sys_privilege where id=#{id}";
    	
    }
}
