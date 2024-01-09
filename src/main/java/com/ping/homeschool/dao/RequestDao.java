package com.ping.homeschool.dao;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.Request;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestDao {

    /**
     * 新增系统请求
     */
    int addRequest(Request request);

    /**
     * 删除系统请求
     */
    int deleteRequest(int requestId);

    /**
     * 【重点】修改系统请求
     */
    int updateRequest(@Param("requestId") int requestId, @Param("requestStatus") int requestStatus);

    /**
     * 统计账号注册请求数量
     */
    int countRequestRegist(JSONObject jsonObject);

    /**
     * 统计班级创建请求数量
     */
    int countRequestClass(JSONObject jsonObject);

    /**
     * 账号注册请求列表
     */
    List<JSONObject> listRequestRegist(JSONObject jsonObject);

    /**
     * 班级创建请求列表
     */
    List<JSONObject> listRequestClass(JSONObject jsonObject);

}
