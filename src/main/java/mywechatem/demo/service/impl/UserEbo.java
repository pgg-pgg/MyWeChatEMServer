package mywechatem.demo.service.impl;

import mywechatem.demo.dao.UserDao;
import mywechatem.demo.domain.User;
import mywechatem.demo.service.UserEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserEbo implements UserEbi {

    @Resource
    public UserDao userDao;

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User searchUserById(String id) {
        return userDao.searchUserById(id);
    }

    @Override
    public String searchIdByTel(String tel) {
        return userDao.searchIdByTel(tel);
    }

    @Override
    public void deleteUserById(String id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void UpdateUserPwd(User user) {
        userDao.UpdateUserPwd(user);
    }

    @Override
    public void UpdateUserHeadUrl(User user) {
        userDao.UpdateUserHeadUrl(user);
    }

    @Override
    public void UpdateUserName(User user) {
        userDao.UpdateUserName(user);
    }

    @Override
    public void UpdateUserSignature(User user) {
        userDao.UpdateUserSignature(user);
    }

    @Override
    public void UpdateUserSex(User user) {
        userDao.UpdateUserSex(user);
    }

    @Override
    public void UpdateUserLocation(User user) {
        userDao.UpdateUserLocation(user);
    }

    @Override
    public void UpdateUserBirthday(User user) {
        userDao.UpdateUserBirthday(user);
    }

    @Override
    public void UpdateUserBackgroundUrl(User user) {
        userDao.UpdateUserBackgroundUrl(user);
    }

    @Override
    public List<User> searchUserByListString(String[] telephone) {
        return userDao.searchUserByListString(telephone);
    }
}
