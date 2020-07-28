package com.nanda.service;

import com.nanda.dao.FansDao;
import com.nanda.vo.Fans;
import com.nanda.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ClientInfoStatus;
import java.util.List;

@Service
public class FansService {
    @Resource
    private FansDao fansDao;

    /**
     * 获取关注数量
     * @param userId
     * @return
     */
    public int getgznumber(int userId){
        int n = fansDao.queryNumberByUserId(userId);
        return n;
    }

    /**
     * 获取粉丝数量
     * @param idolId
     * @return
     */
    public int getfsnumber(int idolId){
        int n = fansDao.queryNumberByIdolId(idolId);
        return n;
    }

    /**
     * 获取关注的所有用户
     * @param userId
     * @return
     */
    public List<User> getgzUser(int userId){
        List<User> list = fansDao.querygzUser(userId);
        return list;
    }

    /**
     * 获取粉丝用户名
     * @param idolId
     * @return
     */
    public List<User> getfsUser(int idolId){
        List<User> list = fansDao.queryfsUser(idolId);
        return list;
    }

    /**
     * 插入关注用户和被关注用户
     * @param userId
     * @param idolId
     * @return
     */
    public int insertFans(int userId,int idolId){
        if (userId == idolId){
            return -2;
        }
        List<User> list = fansDao.querygzUser(userId);
        for (User u:list) {
            if (idolId == u.getUserId()){
                return -1;
            }
        }
        Fans fans = new Fans();
        fans.setUserId(userId);
        fans.setIdolId(idolId);
        int i = fansDao.insertFans(fans);
        return i;
    }
}
