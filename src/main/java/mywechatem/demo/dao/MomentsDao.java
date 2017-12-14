package mywechatem.demo.dao;


import mywechatem.demo.domain.Moments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MomentsDao {

    /**
     * 插入一条说说
     */
    void insertMoments(Moments moments);

    /**
     * 删除一条说说
     */
    void deleteMoments(String id);

    /**
     * 删除一个用户的所有说说
     */
    void deleteMomentsFromUser(String userId);

    /**
     * 查找用户的所有好友的说说
     */
    List<Moments> searchMoments(String[] userId);


}
