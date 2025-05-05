package com.example.Kcsj.controller;
import com.example.Kcsj.common.Result;
import com.example.Kcsj.entity.Message;
import com.example.Kcsj.mapper.MessageMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    MessageMapper messageMapper;

    @GetMapping("/all")
    public Result<?> GetAll() {
        return Result.success(messageMapper.selectList(null));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id) {
        messageMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<?> updates(@RequestBody Message message) {
        messageMapper.updateById(message);
        return Result.success();
    }


    @PostMapping
    public Result<?> save(@RequestBody Message message) {
        messageMapper.insert(message);
        return Result.success();
    }
}
