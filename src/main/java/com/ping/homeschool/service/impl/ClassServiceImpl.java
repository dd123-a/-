package com.ping.homeschool.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.dao.ClassDao;
import com.ping.homeschool.model.MyClass;
import com.ping.homeschool.service.ClassService;
import com.ping.homeschool.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;

    @Override
    public JSONObject deleteClass(int classId) {
        if(classDao.deleteClass(classId) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject updateClass(JSONObject jsonObject) {
        if(classDao.updateClassTop(jsonObject.getInteger("classId"), jsonObject.getString("classTop")) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject selectById(int classId) {
        JSONObject info = new JSONObject();
        MyClass myClass = classDao.selectById(classId);
        if(myClass != null){
            info.put("result", myClass);
            return CommonUtil.successJson(info);
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject listClass(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = classDao.countClass(jsonObject);
        List<JSONObject> list = classDao.listClass(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject listMyClass(int userId) {
        JSONObject info = new JSONObject();
        List<MyClass> list = classDao.listMyClass(userId);
        if(list != null){
            info.put("list", list);
            return CommonUtil.successJson(info);
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject expelMember(JSONObject jsonObject) {
        if(classDao.expelMember(jsonObject.getInteger("userId"), jsonObject.getInteger("classId")) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();

    }

    @Override
    public JSONObject exitClass(JSONObject jsonObject) {
        if(classDao.expelMember(jsonObject.getInteger("userId"), jsonObject.getInteger("classId")) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject listMember(int classId) {
        JSONObject info = new JSONObject();
        List<JSONObject> list = classDao.listMember(classId);
        if(list != null){
            info.put("list", list);
            return CommonUtil.successJson(info);
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject isMember(JSONObject jsonObject){
        if(classDao.isMember(jsonObject.getInteger("userId"), jsonObject.getInteger("classId")) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject addJoin(JSONObject jsonObject) {
        if(classDao.addJoin(jsonObject) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject updateJoin(JSONObject jsonObject) {
        int AGREE = 2; //同意加入班级
        int DISAGREE = 3; //拒绝加入班级

        int status = jsonObject.getInteger("joinStatus");
        //将该用户加入班级
        if(status == AGREE){
            int res = classDao.addMember(jsonObject.getInteger("memberId"), jsonObject.getInteger("classId"));
            if(res > 0){
                classDao.updateJoin(jsonObject);
                return CommonUtil.successResult();
            }
            return CommonUtil.failResult();
        }else if(status == DISAGREE){
            if(classDao.updateJoin(jsonObject) > 0) {
                return CommonUtil.successResult();
            }
            return CommonUtil.failResult();
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject listJoin(int classAdviser) {
        JSONObject info = new JSONObject();
        List<JSONObject> list = classDao.listJoin(classAdviser);
        if(list != null){
            info.put("list", list);
            return CommonUtil.successJson(info);
        }
        return CommonUtil.failResult();
    }

    @Override
    public JSONObject checkJoin(JSONObject jsonObject){
        if(classDao.checkJoin(jsonObject) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();
    }
}
