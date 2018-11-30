package com.su.model;

import java.io.Serializable;
import java.util.List;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年10月22日下午4:34:17
* 创建描述：
* 
* 修 改 者：  
* 修改时间： 
* 修改描述： SerializedCache 序列 缓存
* 
* 审 核 者：
* 审核时间：
* 审核描述：角色表
*
 */

public class SysRoles implements Serializable{
	
	private static final long serialVersionUID = 8532799030888554252L;
	//角色ID
	private Long id;
	//角色名
	private String roleName;
	//有效标志
	private int enabled;
	
	private CreateInfo createInfo;
	
	private SysUser user;
	//角色包含的权限列表
	private List<SysPrivilege>  PrivilegeList;
	
	public List<SysPrivilege> getPrivilegeList() {
		return PrivilegeList;
	}
	public void setPrivilegeList(List<SysPrivilege> privilegeList) {
		PrivilegeList = privilegeList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public CreateInfo getCreateInfo() {
		return createInfo;
	}
	public void setCreateInfo(CreateInfo createInfo) {
		this.createInfo = createInfo;
	}
}
