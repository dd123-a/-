package com.ping.homeschool.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.dao.MessageDao;
import com.ping.homeschool.model.Message;
import com.ping.homeschool.service.MessageService;
import com.ping.homeschool.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public JSONObject addMessage(Message message) {
        message.setSendTime(new Date());
        if(messageDao.addMessage(message) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject deleteMessage(int messageId) {
        if(messageDao.deleteMessage(messageId) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject updateMessage(int messageId) {
        if(messageDao.updateMessage(messageId) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject selectMessage(int messageId) {
        Message message = messageDao.selectById(messageId);
        System.out.println(message.toString());
        if(message != null){
            JSONObject info = new JSONObject();
            info.put("result", message);
            return CommonUtil.successJson(info);
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject listSenderMessage(String sender) {
        JSONObject info = new JSONObject();
        List<JSONObject> list = messageDao.listSenderMessage(sender);
        if(list != null){
            info.put("list", list);
            return CommonUtil.successJson(info);
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject listRecipientMessage(String recipient) {
        JSONObject info = new JSONObject();
        List<JSONObject> list = messageDao.listRecipientMessage(recipient);
        if(list != null){
            info.put("list", list);
            return CommonUtil.successJson(info);
        }
        return CommonUtil.failResult();
    }

    // 【重点】需要提取条件（如果有）
    @Override
    public JSONObject queryByMany(JSONObject jsonObject) {
        // 处理天数，转换为起始日期
        Integer day = jsonObject.getInteger("day");
        if(day != null){
            Date end = new Date();
            jsonObject.put("end", end);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(end);
            calendar.add(Calendar.DAY_OF_MONTH, -day);
            Date start = calendar.getTime();
            System.out.println("start：" + start);
            System.out.println("end：" + end);
            jsonObject.put("start", start);
        }
        List<JSONObject> list = messageDao.queryByMany(jsonObject);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("list", list);
        if(list != null){
            return CommonUtil.successJson(jsonObject1);
        }
        return CommonUtil.failResult();
    }
}
