package com.ping.homeschool.service;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.ClassNotice;

public interface ClassNoticeService {
    /**
     * 新增班级通知
     */
    JSONObject addClassNotice(ClassNotice classNotice);

    /**
     * 删除班级通知
     */
    JSONObject deleteClassNotice(int classNoticeId);

    /**
     * 根据id查询班级通知
     */
    JSONObject selectById(int classNoticeId);

    /**
     * 班级通知列表【分页】
     */
    JSONObject listClassNotice(JSONObject jsonObject);

    /**
     * 班级通知列表
     */
    JSONObject listAll(int classId);

    /**
     * 多条件查询
     */
    JSONObject queryByMany(JSONObject jsonObject);
}
