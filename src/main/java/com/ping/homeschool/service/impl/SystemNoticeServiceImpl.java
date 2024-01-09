package com.ping.homeschool.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.dao.SystemNoticeDao;
import com.ping.homeschool.model.SystemNotice;
import com.ping.homeschool.service.SystemNoticeService;
import com.ping.homeschool.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SystemNoticeServiceImpl implements SystemNoticeService {
    @Autowired
    private SystemNoticeDao systemNoticeDao;

    @Override
    public JSONObject addSystemNotice(SystemNotice systemNotice) {
        systemNotice.setSystemNoticeTime(new Date());
        if(systemNoticeDao.addSystemNotice(systemNotice) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject deleteSystemNotice(int systemNoticeId) {
        if(systemNoticeDao.deleteSystemNotice(systemNoticeId) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject selectById(int systemNoticeId) {
        JSONObject info = new JSONObject();
        SystemNotice systemNotice = systemNoticeDao.selectById(systemNoticeId);
        if(systemNotice != null) {
            info.put("result", systemNotice);
            return CommonUtil.successJson(info);
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject listSystemNotice(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = systemNoticeDao.countSystemNotice(jsonObject);
        List<JSONObject> list = systemNoticeDao.listSystemNotice(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject listAll() {
        List<JSONObject> list = systemNoticeDao.selectAll();
        JSONObject info = new JSONObject();
        info.put("list", list);
        return CommonUtil.successJson(info);
    }
}
