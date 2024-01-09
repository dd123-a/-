package com.ping.homeschool.dao;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.SystemNotice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemNoticeDao {
    /**
     * 新增系统通知
     */
    int addSystemNotice(SystemNotice systemNotice);

    /**
     * 删除系统通知
     */
    int deleteSystemNotice(int systemNoticeId);

    /**
     * 查询系统通知
     */
    SystemNotice selectById(int systemNoticeId);

    /**
     * 统计系统通知数量
     */
    int countSystemNotice(JSONObject jsonObject);

    /**
     * 系统通知列表【分页】
     */
    List<JSONObject> listSystemNotice(JSONObject jsonObject);

    /**
     * 系统通知列表【不分页】
     */
    List<JSONObject> selectAll();
}
