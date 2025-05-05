package com.example.Kcsj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.NoArgsConstructor;

@TableName("category")
@Data // Lombok 注解，自动生成 getter、setter、toString 等方法
@Builder // Lombok 注解，支持 Builder 模式
@AllArgsConstructor // Lombok 注解，生成全参构造函数
@NoArgsConstructor // Lombok 注解，生成无参构造函数
public class Category {

    @TableId(type = IdType.AUTO) // 主键自增
    private Integer id;
    private String name;
    private String detail;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
