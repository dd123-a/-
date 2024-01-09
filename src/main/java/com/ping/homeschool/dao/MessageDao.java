package com.ping.homeschool.dao;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {

    /**
     * 新增消息
     */
    int addMessage(Message message);

    /**
     * 删除消息
     */
    int deleteMessage(int messageId);

    /**
     * 修改消息【状态】
     */
    int updateMessage(int messageId);

    /**
     * 根据id查询消息
     */
    Message selectById(int messageId);

    /**
     * 已发消息列表
     */
    List<JSONObject> listSenderMessage(String sender);

    /**
     * 已收消息列表
     */
    List<JSONObject> listRecipientMessage(String recipient);

    /**
     * 多条件查询
     */
    List<JSONObject> queryByMany(JSONObject jsonObject);
}
