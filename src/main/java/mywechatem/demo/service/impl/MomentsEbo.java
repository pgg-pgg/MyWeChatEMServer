package mywechatem.demo.service.impl;

import mywechatem.demo.dao.MomentsDao;
import mywechatem.demo.dao.UserDao;
import mywechatem.demo.domain.Moments;
import mywechatem.demo.service.MomentsEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MomentsEbo implements MomentsEbi{


    @Resource
    public MomentsDao momentsDao;

    @Override
    public void insertMoments(Moments moments) {
        momentsDao.insertMoments(moments);
    }

    @Override
    public void deleteMoments(String id) {
        momentsDao.deleteMoments(id);
    }

    @Override
    public void deleteMomentsFromUser(String userId) {
        momentsDao.deleteMomentsFromUser(userId);
    }

    @Override
    public List<Moments> searchMoments(String[] userId) {
        return momentsDao.searchMoments(userId);
    }
}
