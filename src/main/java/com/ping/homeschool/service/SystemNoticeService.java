package com.ping.homeschool.service;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.SystemNotice;

import java.util.List;

public interface SystemNoticeService {
    /**
     * 新增系统通知
     */
   JSONObject addSystemNotice(SystemNotice systemNotice);

   /**
    * 删除系统通知
    */
   JSONObject deleteSystemNotice(int systemNoticeId);

   /**
    * 根据id查询系统通知
    */
   JSONObject selectById(int systemNoticeId);

   /**
    * 系统通知列表【分页】
    */
   JSONObject listSystemNotice(JSONObject jsonObject);

   /**
    * 系统通知列表
    */
   JSONObject listAll();
}
