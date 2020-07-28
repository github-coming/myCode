package com.nanda.service;

import com.nanda.dao.CollectionDao;
import com.nanda.vo.Collections;
import com.nanda.vo.Question;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectionService {
    @Resource
    private CollectionDao collectionDao;

    /**
     * 保存收藏
     * @param questionId
     * @param userId
     * @return
     */
    public int insertCollection(int questionId,int userId){
        List<Question> list = collectionDao.queryCollectionsById(userId);
        for (Question q:list) {
            if (q.getQuestionId() == questionId){
                return -1;
            }
        }
        Collections collection = new Collections();
        collection.setQuestionId(questionId);
        collection.setUserId(userId);
        int i = collectionDao.insertCollection(collection);
        return i;
    }

    /**
     * 获取收藏
     * @param userId
     * @return
     */
    public List<Question> getCollectionsById(int userId){
        List<Question> list = collectionDao.queryCollectionsById(userId);
        return list;
    }
}
