package com.ping.homeschool.service;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.Request;

public interface RequestService {

    /**
     * 添加系统请求
     */
    JSONObject addRequest(Request request);

    /**
     * 删除系统请求
     */
    JSONObject deleteRequest(Integer requestId);

    /**
     * 更改班级请求
     */
    JSONObject updateRequestRegist(Request request);

    /**
     * 更改注册请求
     */
    JSONObject updateRequestClass(Request request);

    /**
     * 系统请求列表【注册申请】
     */
    JSONObject listRequestRegist(JSONObject jsonObject);

    /**
     * 系统请求列表【班级申请】
     */
    JSONObject listRequestClass(JSONObject jsonObject);

}
