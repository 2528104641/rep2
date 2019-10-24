package com.turing.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.turing.mybatis.dao.StudentMapper;
import com.turing.mybatis.entity.Student;

public class Test {
	
	//通过XML配置文件来构建SqlSessionFactory对象
	private static SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		//第一种方式：
//		try {
//			//先获取SqlSessionFactory对象
//			SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//			//获取SqlSessionq（其实就相当于我们以前的Connection对象）
//			//打开session
//			SqlSession session = sqlSessionFactory.openSession();
//			try {
//				Student stu = session.selectOne("com.turing.haha.selectStu", 1);
//				System.out.println(stu);
//			} finally {
//				//关闭session
//				session.close();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//第二种方式：使用接口的方式
//		先获取SqlSessionFactory对象
		try {
			SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
			//打开session
			SqlSession session = sqlSessionFactory.openSession();
			//获取一个接口的实例
			//mapper--->代理对象
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			//调用接口方法
			Student stu = mapper.getStuById(2);
			//打印
			System.out.println(stu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
