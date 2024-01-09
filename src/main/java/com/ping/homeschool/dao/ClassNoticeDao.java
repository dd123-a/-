package com.ping.homeschool.dao;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.ClassNotice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassNoticeDao {
    /**
     * 新增班级通知
     */
    int addClassNotice(ClassNotice classNotice);

    /**
     * 删除班级通知
     */
    int deleteClassNotice(int classNoticeId);

    /**
     * 根据id查询班级通知
     */
    JSONObject selectById(int classNoticeId);

    /**
     * 统计班级通知数量
     */
    int countClassNotice(JSONObject jsonObject);

    /**
     * 班级通知列表【分页】
     */
    List<JSONObject> listClassNotice(JSONObject jsonObject);


    /**
     * 班级通知列表【不分页】
     */
    List<JSONObject> selectAll(int classNoticeId);

    /**
     * 多条件查询
     */
    List<JSONObject> queryByMany(JSONObject jsonObject);
}
