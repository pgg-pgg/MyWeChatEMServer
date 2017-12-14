package mywechatem.demo.dao;

import mywechatem.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    /**
     * 注册用户
     * POST
     * @return
     */
    void insertUser(User user);
    /**
     * 得到一个用户
     */
    User searchUserById(String id);

    /**
     * 通过电话号码查找Id
     * @param tel
     */
    String searchIdByTel(String tel);
    /**
     * 注销一个用户
     */
    void deleteUserById(String id);

    /**
     * 修改用户密码
     */
    void UpdateUserPwd(User user);

    /**
     * 修改用户头像
     */
    void UpdateUserHeadUrl(User user);

    /**
     * 修改用户昵称
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
     * 修改用户背景图
     */
    void UpdateUserBackgroundUrl(User user);

    /**
     * 查找多个用户
     */
    List<User> searchUserByListString(String[] telephone);
}
