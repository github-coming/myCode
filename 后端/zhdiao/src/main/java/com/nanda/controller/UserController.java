package com.nanda.controller;

import com.nanda.service.UserService;
import com.nanda.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String login(@RequestBody User user) {
        Boolean b = userService.userlogin(user.getUserId(),user.getUserPassword());
        if(b){
            return "succ";
        }
        return "fal";
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String add(@RequestBody User user){
//        int userid = Integer.parseInt(userId);
        String i = this.userService.userRegistration(user.getUserId(),user.getUserName(),user.getUserPassword());
        if(i.equals("账号重复")){
            return "repeat";
        }else if (i.equals("注册成功")){
            return "succ";
        }
        System.out.println("前后端连接成功！");
        return  "fal";
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String updateUser(@RequestBody User user){
        int i = userService.updateUser(user);
        if (i>0){
            return "succ";
        }
        return "fal";
    }

    /**
     * 查询用户信息
     * @param u
     * @return
     */
    @RequestMapping(value = "/getuserinfo",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public User getUserInfo(@RequestBody User u){
        User user = userService.getUser(u.getUserId());
        return user;
    }
}
