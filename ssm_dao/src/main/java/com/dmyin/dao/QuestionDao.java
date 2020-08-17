package com.dmyin.dao;


import com.dmyin.entity.QueryPageBean;
import com.dmyin.pojo.Question;

import java.util.List;
import java.util.Map;

public interface QuestionDao {
    Long courseCount(Integer id);


    Long QuestionCount(QueryPageBean queryPageBean);

    List<Question> questionByPageBean(QueryPageBean queryPageBean);

    void addQuestion(Question question);

    void addQuestionDao_tag(Map map);
}
