package com.dmyin.service.impl;


import com.dmyin.dao.QuestionDao;
import com.dmyin.dao.QuestionItemDao;
import com.dmyin.entity.PageResult;
import com.dmyin.entity.QueryPageBean;
import com.dmyin.pojo.Question;
import com.dmyin.pojo.QuestionItem;
import com.dmyin.pojo.Tag;
import com.dmyin.service.QuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionDao questionDao;
    @Resource
    private QuestionItemDao questionItemDao;
@Override
    public PageResult questionByPageBean(QueryPageBean queryPageBean) throws IOException {
        Long questionCount = questionDao.QuestionCount(queryPageBean);
        List<Question> questionList = questionDao.questionByPageBean(queryPageBean);
        PageResult pr = new PageResult();
        pr.setTotal(questionCount);
        pr.setRows(questionList);
        return pr;
    }
    @Transactional
    @Override
    public void insertQuestion(Question question) {
        try {
            //将与t_question有关的信息添加到表中
            questionDao.addQuestion(question);
            //获取所有的选项信息
            List<QuestionItem> questionItemList = question.getQuestionItemList();
            if (questionItemList != null && questionItemList.size() > 0) {
                for (QuestionItem questionItem : questionItemList) {
                    questionItem.setQuestionId(question.getId());
                    questionItemDao.addQuestionItem(questionItem);
                }
            }
            //获取所有的标签信息
            List<Tag> tagList = question.getTagList();
            if (tagList != null && tagList.size() > 0) {
                for (Tag tag : tagList) {
                    Map map = new HashMap<>();
                    map.put("questionId", question.getId());
                    map.put("tagId", tag.getId());
                    questionDao.addQuestionDao_tag(map);
                }
            }
            //上传成功,提交数据
        } catch (Exception e) {
            e.printStackTrace();
            //上传失败,回滚数据
        }
    }
}
