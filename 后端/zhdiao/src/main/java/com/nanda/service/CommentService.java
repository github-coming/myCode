package com.nanda.service;

import com.nanda.dao.CommentDao;
import com.nanda.vo.Comment;
import com.nanda.vo.Question;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CommentService {
    @Resource
    private CommentDao commentDao;

    /**
     * 查询一个问题对应的所有评论
     * @param questionId
     * @return
     */
    public List getAllCommentById(int questionId){
        List<Comment> list = commentDao.queryAllComment(questionId);
        List list1 = new ArrayList();
        for (Comment c:list) {
            Map<String,Object> map = new HashMap<>();
            map.put("commentContent",c.getCommentContent());
            map.put("commentTime",c.getCommentTime());
            map.put("userName",c.getUser().getUserName());
            list1.add(map);
        }
        return list1;
    }

    /**
     * 插入评论
     * @param commentContent
     * @param questionId
     * @param userId
     * @return
     */
    public boolean insertcomment(String commentContent,int questionId,int userId){
        Comment comment = new Comment();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = (String)df.format(new Date());//获取系统时间

        comment.setCommentContent(commentContent);
        comment.setCommentTime(time);
        comment.setQuestionId(questionId);
        comment.setUserId(userId);
        int i = commentDao.insertComment(comment);
        int j = commentDao.updatecomments(questionId);
        if (i>0&&j>0){
            return true;
        }
        return false;
    }
}
