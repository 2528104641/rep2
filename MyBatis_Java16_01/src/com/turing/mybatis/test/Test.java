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
	
	//ͨ��XML�����ļ�������SqlSessionFactory����
	private static SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		//��һ�ַ�ʽ��
//		try {
//			//�Ȼ�ȡSqlSessionFactory����
//			SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//			//��ȡSqlSessionq����ʵ���൱��������ǰ��Connection����
//			//��session
//			SqlSession session = sqlSessionFactory.openSession();
//			try {
//				Student stu = session.selectOne("com.turing.haha.selectStu", 1);
//				System.out.println(stu);
//			} finally {
//				//�ر�session
//				session.close();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//�ڶ��ַ�ʽ��ʹ�ýӿڵķ�ʽ
//		�Ȼ�ȡSqlSessionFactory����
		try {
			SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
			//��session
			SqlSession session = sqlSessionFactory.openSession();
			//��ȡһ���ӿڵ�ʵ��
			//mapper--->�������
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			//���ýӿڷ���
			Student stu = mapper.getStuById(2);
			//��ӡ
			System.out.println(stu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
