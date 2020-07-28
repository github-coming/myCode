package com.nanda.controller;

import com.nanda.service.CollectionService;
import com.nanda.vo.Collections;
import com.nanda.vo.Question;
import com.nanda.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/collection")
public class CollectionController {
    @Resource
    private CollectionService collectionService;

    /**
     *插入收藏
     * @param question
     * @return
     */
    @RequestMapping(value = "/insertcollection",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String insertCollection(@RequestBody Question question){
        int i = collectionService.insertCollection(question.getQuestionId(),question.getUserId());
        if (i==-1){
            return "repeat";
        }else if (i>0){
            return "succ";
        }
        return "fal";
    }

    /**
     * 获取用户收藏
     * @param user
     * @return
     */
    @RequestMapping(value = "/getcollection",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public List<Question> getCollection(@RequestBody User user){
        List<Question> list = collectionService.getCollectionsById(user.getUserId());
        return list;
    }
}
