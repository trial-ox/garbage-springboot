package com.example.Kcsj.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Kcsj.common.Result;
import com.example.Kcsj.entity.Carousel;
import com.example.Kcsj.mapper.CarouselMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Resource
    CarouselMapper carouselMapper;

    @GetMapping("/all")
    public Result<?> GetAll() {
        return Result.success(carouselMapper.selectList(null));
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {
        LambdaQueryWrapper<Carousel> wrapper = Wrappers.<Carousel>lambdaQuery();
        wrapper.orderByDesc(Carousel::getId);
        if (StrUtil.isNotBlank(search)) {
            wrapper.like(Carousel::getTime, search);
        }
        Page<Carousel> Page = carouselMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(Page);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable int id) {
        carouselMapper.deleteById(id);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<?> updates(@RequestBody Carousel carousel) {
        carouselMapper.updateById(carousel);
        return Result.success();
    }


    @PostMapping
    public Result<?> save(@RequestBody Carousel carousel) {
        carousel.setTime(new Date());
        carouselMapper.insert(carousel);
        return Result.success();
    }
}
