package com.nanda.controller;

import com.nanda.service.CommentService;
import com.nanda.vo.Comment;
import com.nanda.vo.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    /**
     * 根据问题查找所有评论
     * @param question
     * @return
     */
    @RequestMapping(value = "/getcomment",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public List getAllComment(@RequestBody Question question){
        List list = commentService.getAllCommentById(question.getQuestionId());
        return list;
    }

    /**
     * 插入评论
     * @param comment
     * @return
     */
    @RequestMapping(value = "/insertcomment",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String insertComment(@RequestBody Comment comment){
        Boolean b = commentService.insertcomment(comment.getCommentContent(),comment.getQuestionId(),comment.getUserId());
        if(b){
            return "succ";
        }
        return "fal";
    }
}
