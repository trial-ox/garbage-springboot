package com.example.Kcsj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("comments") // 指定数据库表名
@Data // Lombok 注解，自动生成 getter、setter、toString 等方法
@Builder // Lombok 注解，支持 Builder 模式
@AllArgsConstructor // Lombok 注解，生成全参构造函数
@NoArgsConstructor // Lombok 注解，生成无参构造函数
public class Comments {
    @TableId(type = IdType.AUTO) // 主键自增
    private Integer id; // 评论ID
    private Integer invitationId; // 帖子ID
    private String text; // 评论内容
    private String username;
    private String avatar;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") // 时间格式化
    private Date createdAt; // 评论创建时间

    // Getter 和 Setter 方法（Lombok 的 @Data 注解已经自动生成，这里可以省略）
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}