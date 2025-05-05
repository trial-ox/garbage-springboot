package com.example.Kcsj.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Kcsj.common.Result;
import com.example.Kcsj.entity.Question;
import com.example.Kcsj.mapper.QuestionsMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
    @Resource
    QuestionsMapper questionsMapper;

    @GetMapping("/all")
    public Result<?> GetAll() {
        return Result.success(questionsMapper.selectList(null));
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search,
                              @RequestParam(defaultValue = "") String search1,
                              @RequestParam(defaultValue = "") String search2,
                              @RequestParam(defaultValue = "") String search3) {
        LambdaQueryWrapper<Question> wrapper = Wrappers.<Question>lambdaQuery();
        wrapper.orderByDesc(Question::getId);
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Question::getQuestionId, search);
        }
        if (StrUtil.isNotBlank(search1)) {
            wrapper.like(Question::getTitle, search1);
        }
        Page<Question> Page = questionsMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(Page);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id) {
        questionsMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<?> updates(@RequestBody Question question) {
        questionsMapper.updateById(question);
        return Result.success();
    }


    @PostMapping
    public Result<?> save(@RequestBody Question question) {
        question.setTime(new Date());
        questionsMapper.insert(question);
        return Result.success();
    }

    @GetMapping("/{questionId}")
    public Result<?> getByquestionId(@PathVariable String questionId) {
        System.out.println(questionId);
        return Result.success(questionsMapper.selectByQuestionId(questionId));
    }
}
