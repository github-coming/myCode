package com.nanda.controller;

import com.nanda.service.QuestionService;
import com.nanda.vo.Question;
import com.nanda.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    /**
     * 查询除用户以外用户提出的问题
     * @param user
     * @return
     */
    @RequestMapping(value = "/getquestion",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public List<Question> getAllQuestion(@RequestBody User user){
        List<Question> list = questionService.getAllQuestionInfo(user.getUserId());
        return list;
    }

    /**
     * 查询单个问题的信息
     * @param question
     * @return
     */
    @RequestMapping(value = "/getonequestion",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Map<String,Object> getQuesetion(@RequestBody Question question){
        Map<String,Object> map = questionService.getQuestionById(question.getQuestionId());
        return map;
    }

    /**
     * 查询个人提出的所有问题
     * @param user
     * @return
     */
    @RequestMapping(value = "/getquestionbyid",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public List<Question> getAllQuestionById(@RequestBody User user){
        List<Question> list = questionService.getAllQuestionById(user.getUserId());
        return list;
    }

    /**
     * 插入问题信息
     * @param question
     * @return
     */
    @RequestMapping(value = "/insertquestion",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String insertQuestion(@RequestBody Question question){
        int i = questionService.insertQuestion(question.getQuestionTitle(),question.getQuestionContent(),question.getUserId());
        if (i>0){
            return "succ";
        }
        return "fal";
    }
}
