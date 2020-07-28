package com.nanda.controller;

import com.nanda.service.FansService;
import com.nanda.vo.Fans;
import com.nanda.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/fans")
public class FansController {
    @Resource
    private FansService fansService;

    /**
     * 获取关注数
     * @param user
     * @return
     */
    @RequestMapping(value = "/getgznumber",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public int getgznumber(@RequestBody User user){
        int n = fansService.getgznumber(user.getUserId());
        return n;
    }

    /**
     * 获取粉丝数
     * @param user
     * @return
     */
    @RequestMapping(value = "/getfsnumber",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public int getfsnumber(@RequestBody User user){
        int n = fansService.getfsnumber(user.getUserId());
        return n;
    }

    /**
     * 获取关注的所有用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/getgzuser",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public List<User> getgzUser(@RequestBody User user){
        List<User> list = fansService.getgzUser(user.getUserId());
        return list;
    }

    /**
     * 获取粉丝的所有用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/getfsuser",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public List<User> getfsUser(@RequestBody User user){
        List<User> list = fansService.getfsUser(user.getUserId());
        return list;
    }

    /**
     * 插入关注
     * @param fans
     * @return
     */
    @RequestMapping(value = "/insertfans",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String insertFans(@RequestBody Fans fans){
        int i = fansService.insertFans(fans.getUserId(),fans.getIdolId());
        if (i == -2){
            return "no";
        }else if(i == -1){
            return "repeat";
        }else if(i>0){
            return "succ";
        }
        return "fal";
    }
}
