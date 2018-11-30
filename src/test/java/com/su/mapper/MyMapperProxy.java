package com.su.mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年10月24日下午5:46:31
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

public class MyMapperProxy<T> implements InvocationHandler{
    
	private Class<T> mapperInterface;
	
	private SqlSession sqlSession;
	
	public MyMapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
		super();
		this.mapperInterface = mapperInterface;
		this.sqlSession = sqlSession;
	}


	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//针对不同的 sql 类型，需要调用 sqlSe ss 不同的
		List<T> list=sqlSession.selectList(mapperInterface.getCanonicalName()+"."+method.getName());
		return list;
	}

}
