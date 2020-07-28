package com.nanda.dao;

import com.nanda.vo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentDao {
    List<Comment> queryAllComment(int questionId);
    int insertComment(Comment comment);
    int updatecomments(int questionId);
}
