package com.example.Kcsj.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Kcsj.common.Result;
import com.example.Kcsj.entity.QuestionsRecord;
import com.example.Kcsj.mapper.QuestionsRecordMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/questionsRecord")
public class QuestionsRecordController {
    @Resource
    QuestionsRecordMapper questionsRecordMapper;

    @GetMapping("/all")
    public Result<?> GetAll() {
        return Result.success(questionsRecordMapper.selectList(null));
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search,
                              @RequestParam(defaultValue = "") String search1,
                              @RequestParam(defaultValue = "") String search2,
                              @RequestParam(defaultValue = "") String search3) {
        LambdaQueryWrapper<QuestionsRecord> wrapper = Wrappers.<QuestionsRecord>lambdaQuery();
        wrapper.orderByDesc(QuestionsRecord::getId);
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(QuestionsRecord::getUsername, search);
        }
        if (StrUtil.isNotBlank(search1)) {
            wrapper.like(QuestionsRecord::getQuestionId, search1);
        }
        if (StrUtil.isNotBlank(search2)) {
            wrapper.like(QuestionsRecord::getTitle, search2);
        }
        Page<QuestionsRecord> Page = questionsRecordMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(Page);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id) {
        questionsRecordMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<?> updates(@RequestBody QuestionsRecord questionsRecord) {
        questionsRecordMapper.updateById(questionsRecord);
        return Result.success();
    }


    @PostMapping
    public Result<?> save(@RequestBody QuestionsRecord questionsRecord) {
        questionsRecord.setTime(new Date());
        questionsRecordMapper.insert(questionsRecord);
        return Result.success();
    }
}
