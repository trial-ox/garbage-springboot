package com.example.Kcsj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.Kcsj.entity.Question;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface QuestionsMapper extends BaseMapper<Question> {
    @Select("select * from question where question_id = #{questionId}")
    List<Question> selectByQuestionId(String questionId);
}
