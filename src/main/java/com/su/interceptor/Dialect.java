package com.su.interceptor;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.RowBounds;

/***
 * 
* 
* 描    述：
*
* 创 建 者： wangl
* 创建时间：  2018年11月22日下午2:42:36
* 创建描述：
* 
* 修 改 者：  
* 修改时间： 
* 修改描述： 
* 
* 审 核 者：
* 审核时间：
* 审核描述：数据库方言,针对不同数据库分别实现
*
 */
@SuppressWarnings("rawtypes")
public interface Dialect {
    /**
     * 跳过count和分页查询
     * @param msId  执行的Mybatis方法全名
     * @param parameterObject  方法参数
     * @param rowBounds  分页参数
     * @return  true  跳过,返回默认查询结果,false则执行分页查询
     */
	boolean skip(String msId,Object parameterObject,RowBounds rowBounds);
	/**
	 * 执行分页前,返回true会进行count查询,返回false会继续下面的beforePage判断
	 * @param msId   执行的mybatis方法全名
	 * @param parameterObject   方法参数
	 * @param rowBounds   分页参数
	 * @return
	 */
	boolean beforeCount(String msId,Object parameterObject,RowBounds rowBounds);
	/**
	 * 生成count查询sql
	 * @param boundSql   绑定sql对象
	 * @param parameterObject   方法参数
	 * @param rowBounds    分页参数
	 * @param cacheKey   count缓存key
	 * @return
	 */
	String getCountSql(BoundSql boundSql,Object parameterObject,RowBounds rowBounds,CacheKey cacheKey);
	/**
	 * 执行完count查询后
	 * @param count    查询结果总数
	 * @param parameterObject    接口参数
	 * @param rowBounds   分页参数
	 */
	void afterCount(long count,Object parameterObject,RowBounds rowBounds);
	/**
	 * 执行分页前返回true会进行分页查询,返回false会返回默认查询结果
	 * @param msId    执行的mybatis方法全名
	 * @param parameterObject    方法参数
	 * @param rowBounds     分页参数 
	 * @return
	 */
	boolean beforePage(String msId,Object parameterObject,RowBounds rowBounds);
	/**
	 * 生成分页查询sql
	 * @param boundSql     绑定sql对象
	 * @param parameterObject      方法参数
	 * @param rowBounds      分页参数
	 * @param cacheKey    分页缓存key
	 * @return
	 */
	String getPageSql(BoundSql boundSql,Object parameterObject,RowBounds rowBounds,CacheKey cacheKey);
	/**
	 * 分页查询后处理分页结果,拦截器中直接return该方法的返回值
	 * @param PageList     分页查询结果
	 * @param parameterObject      方法参数
	 * @param rowBounds     分页参数
	 * @return
	 */
	Object afterPage(List PageList,Object parameterObject,RowBounds rowBounds);
	/**
	 * 设置参数,插件属性
	 * @param properties
	 */
	void setProperties(Properties properties);
}
