package com.su.interceptor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年11月22日下午1:42:16
* 创建描述：
* 
* 修 改 者：  
* 修改时间： 
* 修改描述：mybatis通用分页拦截器 
* 
* 审 核 者：
* 审核时间：
* 审核描述：
*
 */
@SuppressWarnings(value = { "rawtypes","unchecked" })
@Intercepts(@Signature(args = { MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class }, method = "query", type = Executor.class))
public class PageInterceptor implements Interceptor{
    
	private static final List<ResultMapping> EMPTY_RESULTMAPPING=new ArrayList<ResultMapping>(0);
	
	private Dialect dialect;
	
	private Field additionalParametersField;
	
	public Object intercept(Invocation invocation) throws Throwable {
		
		Object[] args=invocation.getArgs();
		
		MappedStatement ms=(MappedStatement) args[0];
		
		Object parameterObject=args[1];
		
		RowBounds rowBounds=(RowBounds) args[2];
		//调用方法判断是否需要进行分页,如果不需要直接返回结果
		if(!dialect.skip(ms.getId(), parameterObject, rowBounds)){
			
			ResultHandler resultHandler=(ResultHandler) args[2];
			//当前目标对象
			Executor executor=(Executor) invocation.getTarget();
			
			BoundSql boundSql=ms.getBoundSql(parameterObject);
			//反射获取动态参数
			Map<String,Object> additionalParameters=(Map<String, Object>) additionalParametersField.get(boundSql);
		    //判断是否需要进行count查询
			if(dialect.beforeCount(ms.getId(), parameterObject, rowBounds)){
				//根据当前的ms创建一个返回值为Long类型的ms
				//MappedStatement countMs = new MappedStatement(ms,Long.class);
			}
		}
		return null;
	}

	public Object plugin(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}

}
