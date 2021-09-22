package com.star.controller;

import com.star.entity.Comment;
import com.star.entity.User;
import com.star.queryvo.DetailedBlog;
import com.star.service.BlogService;
import com.star.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: 评论控制器

 */
@Controller
//@RequestMapping("/templates")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

//    查询评论列表
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

//    新增评论
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session,Model model) {
        Long blogId = comment.getBlogId();
        User user = (User) session.getAttribute("user");
        /*if (user != null&&user.getType()==1&&user.getNickname().equals(comment.getNickname())) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
            if (comment.getParentComment().getId() != null) {
                comment.setParentCommentId(comment.getParentComment().getId());
            }
            commentService.saveComment(comment);
            List<Comment> comments = commentService.listCommentByBlogId(blogId);
            model.addAttribute("comments", comments);
        } else if(user != null&&user.getType()==2&&user.getNickname().equals(comment.getNickname())){
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(false);
            if (comment.getParentComment().getId() != null) {
                comment.setParentCommentId(comment.getParentComment().getId());
            }
            commentService.saveComment(comment);
            List<Comment> comments = commentService.listCommentByBlogId(blogId);
            model.addAttribute("comments", comments);
        }*/
        if (user != null&&user.getNickname().equals(comment.getNickname())&&user.getEmail().equals(comment.getEmail())){
            comment.setAvatar(user.getAvatar());
            if (user.getType()==1){
                comment.setAdminComment(true);
            }else if(user.getType()==2){
                comment.setAdminComment(false);
            }
            if (comment.getParentComment().getId() != null) {
                comment.setParentCommentId(comment.getParentComment().getId());
            }
            commentService.saveComment(comment);
            List<Comment> comments = commentService.listCommentByBlogId(blogId);
            model.addAttribute("comments", comments);
        }


        return "blog :: commentList";
    }

//    删除评论
    @GetMapping("/comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Long blogId, @PathVariable Long id,Comment comment, RedirectAttributes attributes, Model model){
        commentService.deleteComment(comment,id);
        DetailedBlog detailedBlog = blogService.getDetailedBlog(blogId);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("blog", detailedBlog);
        model.addAttribute("comments", comments);
        return "blog";
    }

    @GetMapping("/footer/blogmessage")
    public String blogMessage(Model model){

        int blogTotal = blogService.getBlogTotal();
        int blogViewTotal = blogService.getBlogViewTotal();
        int blogCommentTotal = blogService.getBlogCommentTotal();
        int blogMessageTotal = blogService.getBlogMessageTotal();

        model.addAttribute("blogTotal",blogTotal);
        model.addAttribute("blogViewTotal",blogViewTotal);
        model.addAttribute("blogCommentTotal",blogCommentTotal);
        model.addAttribute("blogMessageTotal",blogMessageTotal);
        return "index :: blogMessage";
    }

}