package com.nanda.dao;

import com.nanda.vo.Collections;
import com.nanda.vo.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionDao {
    int insertCollection(Collections collection);
    List<Question> queryCollectionsById(int UserId);
}
