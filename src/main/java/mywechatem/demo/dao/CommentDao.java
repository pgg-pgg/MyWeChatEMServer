package mywechatem.demo.dao;


import mywechatem.demo.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentDao {

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
