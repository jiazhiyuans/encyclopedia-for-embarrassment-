package com.alieducation.dao;


import com.alieducation.entity.mongodb.MongoMessage;
import com.alieducation.entity.mongodb.MongoUser;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.apache.ibatis.annotations.Mapper;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @author JiaZhiYuan
 * @version 1.0
 * @date 2020/6/26 12:55
 */
@Mapper
public interface MessageDao {

    /**
     * 查询点对点的连接
     * @param fromId
     * @param toId
     * @param page
     * @param rows
     * @return
     */
    List<MongoMessage> selectMessageByFromAndTo(Long fromId, Long toId, Integer page, Integer rows);

    /**
     * 根据id查询数据
     */

    MongoMessage selectMessageById(String id);

    /**
     * 更新消息的状态
     */

    UpdateResult updateMessageStatusById(ObjectId id, Integer status);

    /**
     * 新增消息
     */

    MongoMessage insertMessage(MongoMessage message);

    /**
     * 根据id删除消息
     */
    DeleteResult deleteMessageById(String id);

    /**
     *
     * @param fromUserId
     * @return
     */
    MongoUser findUserById(long fromUserId);

    /**
     *
     * @param fromUserId
     * @param toUserId
     * @return
     */
    List<MongoMessage> selectNewestMessageOfConversation(long fromUserId, long toUserId);
}
