package com.nanda.dao;

import com.nanda.vo.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao {
    List<Question> queryAllQuestion(int userId);
    List<Question> queryAllQuestionById(int userId);
    Question queryQuestionById(int quesetionId);
//    int deleteQuestionById(int questionId);
//    int deletecommentById(int questionId);
    int insertQuestion(Question question);
}
