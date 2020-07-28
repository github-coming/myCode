package com.nanda.vo;

public class Collections {
    private int collectionId;
    private int questionId;
    private int userId;
    private Question collectQuestion;
    private User user;

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Question getQuestion() {
        return collectQuestion;
    }

    public void setQuestion(Question collectQuestion) {
        this.collectQuestion = collectQuestion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
