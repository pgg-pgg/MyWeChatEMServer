package mywechatem.demo.service;

import mywechatem.demo.domain.Comment;

import java.util.List;

public interface CommentEbi {

    /**
     *     插入一条评论
     */
    void insertComment(Comment comment);

    /**
     * 删除所属说说的所有评论
     */
    void deleteComment(String moments_id);

    /**
     * 查找一条说说的所有评论
     */
    List<Comment> SearchComment(String moments_id);

    /**
     * 得到所有好友说说的所有评论
     */
    List<Comment> searchAllComment(String[] moments_id);
}
