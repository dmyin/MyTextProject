package com.dmyin.service;


import com.dmyin.entity.PageResult;
import com.dmyin.entity.QueryPageBean;
import com.dmyin.pojo.Question;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface QuestionService {

    PageResult questionByPageBean(QueryPageBean queryPageBean) throws IOException;

    @Transactional
    void insertQuestion(Question question);
}
