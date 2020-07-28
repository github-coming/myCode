package com.nanda.service;

import com.nanda.dao.UserDao;
import com.nanda.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    /**
     * 用户注册，插入用户信息
     * @param userId
     * @param userName
     * @param userPassword
     * @return
     */
    public String userRegistration(int userId,String userName,String userPassword){
        List<User> list = userDao.queryAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (userId == list.get(i).getUserId()){
                return "账号重复";
            }
        }
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        int i = userDao.insertUser(user);
        if (i>0){
            return "注册成功";
        }
        return "注册失败";
    }

    /**
     * 用户登录
     * @param userId
     * @param userPassword
     * @return
     */
    public boolean userlogin(int userId,String userPassword){
        List<User> list = userDao.queryAllUser();
        for (int i = 0; i < list.size(); i++) {
            if (userId == list.get(i).getUserId()){
                if (userPassword.equals(list.get(i).getUserPassword())){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateUser(User user){
        int i = userDao.updateUser(user);
        return i;
    }

    /**
     * 根据Id查询用户信息
     * @param userId
     * @return
     */
    public User getUser(int userId){
        User user = userDao.queryUserById(userId);
        return user;
    }

    public User getUserInfo(){
        return userDao.queryUserNameById(1);
    }
}
