package mywechatem.demo.service;

import mywechatem.demo.domain.Moments;

import java.util.List;

public interface MomentsEbi {

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
