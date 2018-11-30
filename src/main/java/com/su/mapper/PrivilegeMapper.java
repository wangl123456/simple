package com.su.mapper;

import org.apache.ibatis.annotations.SelectProvider;

import com.su.model.SysPrivilege;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年10月25日下午3:03:11
* 创建描述：
* 
* 修 改 者：  
* 修改时间： 
* 修改描述： 
* 
* 审 核 者：
* 审核时间：
* 审核描述：测试Provider 注解
*
*/

public interface PrivilegeMapper {

    @SelectProvider(type=PrivilegeProvider.class, method="selectById")
    SysPrivilege  selectById(Long id);
    
    @SelectProvider(type=PrivilegeProvider.class,method="selectById2")
    SysPrivilege selectById2(Long id);
    
}
