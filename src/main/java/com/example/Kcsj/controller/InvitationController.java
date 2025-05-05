package com.example.Kcsj.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Kcsj.common.Result;
import com.example.Kcsj.entity.Invitation;
import com.example.Kcsj.mapper.InvitationMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/invitation")
public class InvitationController {
    @Resource
    InvitationMapper invitationMapper;

    @GetMapping("/all")
    public Result<?> GetAll() {
        return Result.success(invitationMapper.selectList(null));
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search,
                              @RequestParam(defaultValue = "") String search1) {
        LambdaQueryWrapper<Invitation> wrapper = Wrappers.<Invitation>lambdaQuery();
        wrapper.orderByDesc(Invitation::getId);
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Invitation::getTitle, search);
        }
        if (StrUtil.isNotBlank(search1)) {
            wrapper.like(Invitation::getContent, search1);
        }
        Page<Invitation> Page = invitationMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(Page);
    }
    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable int id) {
        return Result.success(invitationMapper.selectById(id));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id) {
        invitationMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<?> updates(@RequestBody Invitation invitation) {
        invitationMapper.updateById(invitation);
        return Result.success();
    }


    @PostMapping
    public Result<?> save(@RequestBody Invitation invitation) {
        invitationMapper.insert(invitation);
        return Result.success();
    }
}
