package com.example.Kcsj.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@TableName("message")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String news;
    private String video;
    private String introduction;
    private String events;
    private String preferentialPolicy;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getPreferentialPolicy() {
        return preferentialPolicy;
    }

    public void setPreferentialPolicy(String preferentialPolicy) {
        this.preferentialPolicy = preferentialPolicy;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
