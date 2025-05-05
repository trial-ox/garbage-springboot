package com.example.Kcsj.controller;

import com.example.Kcsj.common.Result;
import com.example.Kcsj.entity.Comments;
import com.example.Kcsj.mapper.CommentsMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Resource
    private CommentsMapper commentsMapper;

    /**
     * 获取所有评论（嵌套结构）
     */
    @GetMapping("/all")
    public Result<?> getAll() {
        return Result.success(commentsMapper.selectList(null));
    }

    /**
     * 添加评论
     */
    @PostMapping
    public Result<?> save(@RequestBody Comments comments) {
        comments.setCreatedAt(new Date()); // 设置创建时间
        commentsMapper.insert(comments);
        return Result.success(comments);
    }

    /**
     * 更新评论
     */
    @PostMapping("/update")
    public Result<?> update(@RequestBody Comments comments) {
        commentsMapper.updateById(comments);
        return Result.success();
    }

    /**
     * 删除评论
     */
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id) {
        commentsMapper.deleteById(id);
        return Result.success();
    }
}