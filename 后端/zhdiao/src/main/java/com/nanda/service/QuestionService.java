package com.nanda.service;

import com.nanda.dao.QuestionDao;
import com.nanda.vo.Question;
import com.nanda.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {
    @Resource
    private QuestionDao questionDao;

    /**
     * 获取所有问题以及问题的用户名
     * @return
     */
    public List<Question> getAllQuestionInfo(int userId){
        List<Question> list = questionDao.queryAllQuestion(userId);
        return list;
    }

    /**
     * 查询个人提出的所有问题
     * @param userId
     * @return
     */
    public List<Question> getAllQuestionById(int userId){
        List<Question> list = questionDao.queryAllQuestionById(userId);
//        Map<String,Object> map = new HashMap<>();
//        map.put("questionTile",list);
        return list;
    }

//    /**
//     * 删除自己的问题
//     * @param questionId
//     * @return
//     */
//    public boolean deleteQuestion(int questionId){
//        int j = questionDao.deletecommentById(questionId);
//        int i = questionDao.deleteQuestionById(questionId);
//
//        if (i>0 && j>=0){
//            return true;
//        }
//        return false;
//    }

    /**
     * 查询单个问题的详细信息
     * @param questionId
     * @return
     */
    public Map<String,Object> getQuestionById(int questionId){
        Question question = questionDao.queryQuestionById(questionId);
        Map<String,Object> map = new HashMap<>();
        map.put("questionId",question.getQuestionId());
        map.put("questionTitle",question.getQuestionTitle());
        map.put("questionContent",question.getQuestionContent());
        map.put("questionTime",question.getQuestionTime());
        map.put("userId",question.getUser().getUserId());
        map.put("userName",question.getUser().getUserName());
        return map;
    }

    /**
     * 插入用户问题
     * @param questionContent
     * @param userId
     * @return
     */
    public int insertQuestion(String questionTitle,String questionContent,int userId){
        Question question=new Question();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = (String)df.format(new Date());//获取系统时间

        User user = new User();
        user.setUserId(userId);

        question.setQuestionTitle(questionTitle);
        question.setQuestionContent(questionContent);
        question.setQuestionTime(time);
        question.setUser(user);
        question.setComments(0);
        int i = questionDao.insertQuestion(question);
        return i;
    }
}
