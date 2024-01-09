package com.ping.homeschool.controller;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.Message;
import com.ping.homeschool.service.MessageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequiresPermissions("message:add")
    @PostMapping("/sendMessage")
    public JSONObject sendMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }

    @RequiresPermissions("message:delete")
    @GetMapping("/deleteMessage/{messageId}")
    public JSONObject deleteMessage(@PathVariable("messageId") int messageId){
        return messageService.deleteMessage(messageId);
    }

    @RequiresPermissions("message:update")
    @GetMapping("/updateMessage/{messageId}")
    public JSONObject updateMessage(@PathVariable("messageId") int messageId){
        System.out.println("updateMessage");
        return messageService.updateMessage(messageId);
    }

    @GetMapping("/selectMessage/{messageId}")
    public JSONObject selectMessage(@PathVariable("messageId") int messageId){
        System.out.println(messageId);
        return messageService.selectMessage(messageId);
    }

    @RequiresPermissions("message:list")
    @GetMapping("/message/listOutbox/{username}")
    //要先对username解码
    public JSONObject listOutbox(@PathVariable("username") String username) throws UnsupportedEncodingException {
        username = URLDecoder.decode(username, "utf-8");
        return messageService.listSenderMessage(username);
    }

    @RequiresPermissions("message:list")
    @GetMapping("/message/listInbox/{username}")
    //要先对username解码
    public JSONObject listInbox(@PathVariable("username") String username) throws UnsupportedEncodingException {
        username = URLDecoder.decode(username, "utf-8");
        return messageService.listRecipientMessage(username);
    }

    @RequiresPermissions("message:list")
    @PostMapping("/searchMessage")
    public JSONObject searchMessage(@RequestBody JSONObject jsonObject){
        return messageService.queryByMany(jsonObject);
    }
}
