package com.example.Kcsj.controller;

import com.example.Kcsj.common.Result;
import com.example.Kcsj.mapper.CategoryMapper;
import com.example.Kcsj.mapper.CommentsMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 获取所有评论（嵌套结构）
     */
    @GetMapping("/all")
    public Result<?> getAllByName(String name) {
        return Result.success(categoryMapper.selectCategoryByNamePrefix(name));
    }
}
