package mywechatem.demo.service;


import mywechatem.demo.domain.User;

import java.util.List;


public interface UserEbi {
    /**
     * 注册一个用户
     */
    void insertUser(User user);

    /**
     * 通过id找到一个用户
     * @param id
     * @return
     */
    User searchUserById(String id);

    /**
     * 通过手机找到Id
     */
    String searchIdByTel(String tel);

    /**
     * 注销一个用户
     */
    void deleteUserById(String id);

    /**
     * 修改密码
     */
    void UpdateUserPwd(User user);

    /**
     * 修改头像
     */
    void UpdateUserHeadUrl(User user);

    /**
     * 修改昵称
     */
    void UpdateUserName(User user);

    /**
     * 修改用户个性签名
     */
    void UpdateUserSignature(User user);

    /**
     * 修改用户性别
     */
    void UpdateUserSex(User user);

    /**
     * 修改用户地址
     */
    void UpdateUserLocation(User user);

    /**
     * 修改用户生日
     */
    void UpdateUserBirthday(User user);

    /**
     * 修改用户背景
     */
    void UpdateUserBackgroundUrl(User user);

    /**
     * 得到多个用户信息
     */
    List<User> searchUserByListString(String[] telephone);




}
