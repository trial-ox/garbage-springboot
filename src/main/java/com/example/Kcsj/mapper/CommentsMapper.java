package com.example.Kcsj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.Kcsj.entity.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {

    /**
     * 查询评论及其用户信息
     */
    @Select("SELECT c.*, u.name AS user_name, u.avatar AS user_avatar " +
            "FROM comments c " +
            "LEFT JOIN user u ON c.user_id = u.id")
    List<Comments> selectCommentsWithUser();
}