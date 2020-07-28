package com.nanda.dao;

import com.nanda.vo.Fans;
import com.nanda.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FansDao {
    int queryNumberByUserId(int userId);
    int queryNumberByIdolId(int idolId);
    List<User> querygzUser(int userId);
    List<User> queryfsUser(int idolId);
    int insertFans(Fans fans);
}
