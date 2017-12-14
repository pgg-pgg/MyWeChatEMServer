package mywechatem.demo.service.impl;


import mywechatem.demo.dao.CommentDao;
import mywechatem.demo.domain.Comment;
import mywechatem.demo.service.CommentEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentEbo implements CommentEbi {

    @Resource
    private CommentDao commentDao;

    @Override
    public void insertComment(Comment comment) {
        commentDao.insertComment(comment);
    }

    @Override
    public void deleteComment(String moments_id) {
        commentDao.deleteComment(moments_id);
    }

    @Override
    public List<Comment> SearchComment(String moments_id) {
        return commentDao.SearchComment(moments_id);
    }

    @Override
    public List<Comment> searchAllComment(String[] moments_id) {
        return commentDao.searchAllComment(moments_id);
    }
}
