package com.nanda;

import com.nanda.dao.UserDao;
import com.nanda.service.*;
import com.nanda.vo.Collections;
import com.nanda.vo.Comment;
import com.nanda.vo.Question;
import com.nanda.vo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void getUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        UserDao userDao = applicationContext.getBean(UserDao.class);
//        User user = userDao.queryUserById(1);
//        UserService userService = applicationContext.getBean(UserService.class);
//        QuestionService questionService = applicationContext.getBean(QuestionService.class);
//        CommentService commentService = applicationContext.getBean(CommentService.class);
        FansService fansService = applicationContext.getBean(FansService.class);
//        CollectionService collectionService = applicationContext.getBean(CollectionService.class);
//        int i = userService.userRegistration(14,"王五","1234");
//        System.out.println("受到影响的行数："+i);
//        List<Question> list = questionService.getAllQuestionInfo(111);
//        List<Question> list = questionService.getAllQuestionById(666);
//        Question question = questionService.getQuestionById(1);
//        System.out.println(question);
//        boolean b = questionService.deleteQuestion(1);
//        List<Comment> list = commentService.getAllCommentById(1);
//        int n = fansService.getgznumber(1);
//        System.out.println(n);
//        List<User> list = fansService.getgzUser(666);
//        int i = questionService.insertQuestion("你好",1);
//        boolean b = commentService.insertcomment("哈哈哈",1,1);
        int i = fansService.insertFans(1,1);
//        System.out.println(i);
//        int i = collectionService.insertCollection(1,1);
//        List<Question> list = collectionService.getCollectionsById(666);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getUserId());
//        }
//        System.out.println(list.get(1));
//        User user = new User();
//        user.setUserId(111);
//        user.setUserName("1111");
//        user.setUserPassword("1111");
//        int i = userService.updateUser(user);
        System.out.println(i);
//        User user = userService.getUser(1);
//        System.out.println(user);
    }
}
