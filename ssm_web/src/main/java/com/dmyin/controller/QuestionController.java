package com.dmyin.controller;


import com.dmyin.entity.PageResult;
import com.dmyin.entity.QueryPageBean;
import com.dmyin.entity.Result;
import com.dmyin.pojo.Question;
import com.dmyin.service.QuestionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Resource
    private QuestionService qs;

    @RequestMapping("findBasicByPage")
    public Result findBasicByPage(@RequestBody QueryPageBean queryPageBean) throws IOException {
        try {
            PageResult list = qs.questionByPageBean(queryPageBean);
           return new Result(true, "查询问题数据成功", list);
        } catch (Exception e) {
            e.printStackTrace();
           return new Result(false, "查询问题数据失败");
        }
    }

    @RequestMapping("insertQuestion")
    public Result insertQuestion(@RequestBody Question question) throws IOException {
        try {
            qs.insertQuestion(question);
          return new Result(true, "数据上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "数据上传失败");
        }
    }

    /**
     * 上传案例
     */
   /* @RequestMapping("/question/uploadImg")
    public void uploadImg(HttpServletRequest request, HttpServletResponse response) {

    }*/
}
