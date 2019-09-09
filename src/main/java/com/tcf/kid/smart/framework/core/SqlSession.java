package com.tcf.kid.smart.framework.core;

import java.lang.reflect.Proxy;

import com.tcf.kid.smart.framework.config.Configuration;
import com.tcf.kid.smart.framework.proxy.MapperProxyManager;

/***
 * TODO TCF KidORM SQL�Ự
 * TODO TCF ����SQLִ�в��ԣ�����SQLִ����ʵ�����ݳ־û�����
 * TODO TCF ����ӳ�����ӿ����ʹ���JDK��̬����ʵ�������ô�������ʵ�����ݳ־û�����
 * @author 71485
 *
 */
public class SqlSession {

	//TODO TCF KidORM ����������Ϣ
	private Configuration configuration=new Configuration();
	
	//TODO TCF SQLִ����
	private Executor executor=new JDBCExecutor();
	
	//TODO TCF ����SQLִ�в��Ե���SQLִ�����е�SQLִ�в���ʵ�����ݳ־û�����
	public Object selectOne(String sql,String parameter)
	{
		return executor.selectOne(sql,parameter);
	}
	
	//TODO TCF ����ӳ�����ӿ����ʹ���JDK��̬����ʵ�������ô�������ʵ�����ݳ־û�����
	public Object getMapper(Class<?> mapperClass)
	{
		return Proxy.newProxyInstance(mapperClass.getClassLoader(), 
				new Class[] {mapperClass}, 
				new MapperProxyManager(configuration,this));
	}
}