package mywechatem.demo.dao;


import mywechatem.demo.domain.FriendsManage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FriendManageDao {

    /**
     * 添加一个朋友
     */
    void insertFriend(FriendsManage manage);

    /**
     * 解除好友关系
     */
    void deleteFriend(FriendsManage manage);

}
