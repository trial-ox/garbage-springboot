package com.example.Kcsj.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Kcsj.common.Result;
import com.example.Kcsj.entity.Starts;
import com.example.Kcsj.mapper.StartsMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/starts")
public class StartsController {
    @Resource
    StartsMapper startsMapper;

    @GetMapping("/all")
    public Result<?> GetAll() {
        return Result.success(startsMapper.selectList(null));
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search,
                              @RequestParam(defaultValue = "") String search1) {
        LambdaQueryWrapper<Starts> wrapper = Wrappers.<Starts>lambdaQuery();
        wrapper.orderByDesc(Starts::getUsername);
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Starts::getUsername, search);
        }
        if (StrUtil.isNotBlank(search1)) {
            wrapper.like(Starts::getInvitationId, search1);
        }
        Page<Starts> Page = startsMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(Page);
    }
    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable int id) {
        return Result.success(startsMapper.selectById(id));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id) {
        startsMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<?> updates(@RequestBody Starts starts) {
        startsMapper.updateById(starts);
        return Result.success();
    }


    @PostMapping
    public Result<?> save(@RequestBody Starts starts) {
        startsMapper.insert(starts);
        return Result.success();
    }
}
