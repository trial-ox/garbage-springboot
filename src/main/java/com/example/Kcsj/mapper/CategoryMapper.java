package com.example.Kcsj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.Kcsj.entity.Category;
import com.example.Kcsj.entity.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 根据名称前缀查询分类
     */
    @Select("SELECT id, name, detail FROM category WHERE name LIKE CONCAT(#{name}, '%')")
    List<Category> selectCategoryByNamePrefix(String name);
}
