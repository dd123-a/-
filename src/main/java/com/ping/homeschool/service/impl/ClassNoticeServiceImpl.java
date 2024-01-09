package com.ping.homeschool.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.dao.ClassNoticeDao;
import com.ping.homeschool.model.ClassNotice;
import com.ping.homeschool.service.ClassNoticeService;
import com.ping.homeschool.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ClassNoticeServiceImpl implements ClassNoticeService {
    @Autowired
    private ClassNoticeDao classNoticeDao;

    @Override
    public JSONObject addClassNotice(ClassNotice classNotice) {
        classNotice.setClassNoticeTime(new Date());
        if(classNoticeDao.addClassNotice(classNotice) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject deleteClassNotice(int classNoticeId) {
        if(classNoticeDao.deleteClassNotice(classNoticeId) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject selectById(int classNoticeId) {
        JSONObject info = new JSONObject();
        JSONObject jo = classNoticeDao.selectById(classNoticeId);
        if(jo != null) {
            info.put("result", jo);
            return CommonUtil.successJson(info);
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject listClassNotice(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = classNoticeDao.countClassNotice(jsonObject);
        List<JSONObject> list = classNoticeDao.listClassNotice(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject listAll(int classId) {
        List<JSONObject> list = classNoticeDao.selectAll(classId);
        JSONObject info = new JSONObject();
        info.put("list", list);
        return CommonUtil.successJson(info);
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
        System.out.println(jsonObject);
        List<JSONObject> list = classNoticeDao.queryByMany(jsonObject);
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("list", list);
        if(list != null){
            return CommonUtil.successJson(jsonObject1);
        }
        return CommonUtil.failResult();
    }
}
