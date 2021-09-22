package com.star.dao;

import com.star.entity.Blog;
import com.star.queryvo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 博客持久层接口
 * @Mapper注解：让Mybatis找到对应的mapper，在编译的时候动态生成代理类，实现相应SQL功能
 */
@Mapper
@Repository//用来声明dao层的bean（这个注解可有可无，可以消去依赖注入的报错信息）
public interface BlogDao {

    ShowBlog getBlogById(Long id);



    List<Blog> getAllBlog();

    /*时间轴*/
    List<BlogQuery> getAllBlogQuery();

    int saveBlog(Blog blog);

    int updateBlog(ShowBlog showBlog);

    void deleteBlog(Long id);

    List<BlogQuery> searchByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    List<FirstPageBlog> getFirstPageBlog();

    List<RecommendBlog> getAllRecommendBlog();

//    List<FirstPageBlog> getNewBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    int updateViews(Long id);

//    根据博客id查询出评论数量
    int getCommentCountById(Long id);

    List<FirstPageBlog> getByTypeId(Long typeId);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();
}