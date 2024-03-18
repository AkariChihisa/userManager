package com.ch.ch6_6.repository;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ch.ch6_6.entity.MyUser;
/**
 * MyBatis的Mapper映射接口
 */
@Repository
//@Mapper
public interface MyUserRepository {
	public List<MyUser> findAll();
	public int saveUser(MyUser myUser);
	public int deleteUser(Integer id);
	public int updateUser(MyUser myUser);
	public MyUser findUserById(Integer id);
}