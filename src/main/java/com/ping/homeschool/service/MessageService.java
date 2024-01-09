package com.ping.homeschool.service;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.Message;

public interface MessageService {

    /**
     * 新增消息
     */
    JSONObject addMessage(Message message);

    /**
     * 删除消息
     */
    JSONObject deleteMessage(int messageId);

    /**
     * 修改消息【状态】
     */
    JSONObject updateMessage(int messageId);

    /**
     * 查找消息
     */
    JSONObject selectMessage(int messageId);

    /**
     * 已发消息列表
     */
    JSONObject listSenderMessage(String sender);

    /**
     * 已收消息列表
     */
    JSONObject listRecipientMessage(String recipient);

    /**
     * 多条件查询
     */
    JSONObject queryByMany(JSONObject jsonObject);
}
