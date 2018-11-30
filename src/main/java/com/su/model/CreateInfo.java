package com.su.model;

import java.util.Date;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年11月13日上午9:18:41
* 创建描述：
* 
* 修 改 者：  
* 修改时间： 
* 修改描述： 
* 
* 审 核 者：
* 审核时间：
* 审核描述：创建信息
*
 */

public class CreateInfo {
     //创建人
	 private Long createBy;
	 //创建时间
	 private Date  createTime;

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
