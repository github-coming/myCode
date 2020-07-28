package com.nanda.dao;

import com.nanda.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User queryUserNameById(int userId);
    int insertUser(User user);
    List<User> queryAllUser();
    int updateUser(User user);
    User queryUserById(int userId);
}
