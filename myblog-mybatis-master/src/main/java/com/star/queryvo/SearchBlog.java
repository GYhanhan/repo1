package com.star.queryvo;

import java.io.Serializable;

/**
 * @Description: 搜索后台博客管理列表
 */
public class SearchBlog implements Serializable {

    private String title;
    private Long typeId;

    public SearchBlog() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }


    @Override
    public String toString() {
        return "SearchBlog{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}