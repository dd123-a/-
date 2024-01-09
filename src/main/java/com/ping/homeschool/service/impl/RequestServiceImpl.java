package com.ping.homeschool.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.dao.ClassDao;
import com.ping.homeschool.dao.RequestDao;
import com.ping.homeschool.dao.UserDao;
import com.ping.homeschool.model.MyClass;
import com.ping.homeschool.model.Request;
import com.ping.homeschool.model.User;
import com.ping.homeschool.service.RequestService;
import com.ping.homeschool.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestDao requestDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ClassDao classDao;

    @Override
    public JSONObject addRequest(Request request) {
        requestDao.addRequest(request);
        return CommonUtil.successResult();
    }

    @Override
    public JSONObject deleteRequest(Integer requestId) {
        if(requestDao.deleteRequest(requestId) > 0){
            return CommonUtil.successResult();
        }
        return CommonUtil.failResult();

    }

    // 修改注册请求
    @Override
    public JSONObject updateRequestRegist(Request request) {
        int type = request.getRequestType();
        int status = request.getRequestStatus();

        // 教师账号注册申请
        if(type == 1) {
            if (status == 2) {
                String form = request.getRequestForm();
                Map<String, String> map = new HashMap<>();
                User user = new User();
                // 得到key-value
                map = CommonUtil.StringTurnToMap(form);
                System.out.println(map);
                // 填充user
                if (map != null) {
                    user.setUsername(map.get("username"));
                    user.setPassword(map.get("password"));
                    user.setNickname(map.get("nickname"));
                    user.setPhone(map.get("phone"));
                    user.setEmail(map.get("email"));
                    // 设置账号类型为教师
                    user.setRoleId((short) 3);
                }
                int result = userDao.addUser(JSONObject.parseObject(JSONObject.toJSONString(user)));
                if(result > 0){
                    requestDao.updateRequest(request.getRequestId(), request.getRequestStatus());
                    return CommonUtil.successResult();
                }else{
                    return CommonUtil.failResult();
                }
            }else if(status == 3){
                requestDao.updateRequest(request.getRequestId(), request.getRequestStatus());
                return CommonUtil.failResult();
            }else{
                requestDao.deleteRequest(request.getRequestId());
            }
        }

        return CommonUtil.failResult();
    }

    @Override
    public JSONObject updateRequestClass(Request request) {
        int type = request.getRequestType();
        int status = request.getRequestStatus();


        if(type == 2){
            if(status == 2){
                String form = request.getRequestForm();
                Map<String, String> map = new HashMap<>();
                MyClass myClass = new MyClass();
                // 得到key-value
                map = CommonUtil.StringTurnToMap(form);
                System.out.println(map);
                // 填充myClass
                if(map != null){
                    myClass.setClassName(map.get("className"));
                    //前端已经将int转成String
                    myClass.setClassAdviser(Integer.parseInt(map.get("classAdviser")));
                    myClass.setAdviserName(map.get("adviserName"));
                    myClass.setClassInfo(map.get("classInfo"));
                }
                System.out.println(myClass.getClassName());
                int result = classDao.addClass(myClass);

                if(result > 0){
                    // 根据班级名称及创建者及班级简介来查询班级编码
                    int classId = classDao.queryByMany(myClass.getClassName(), myClass.getClassAdviser(), myClass.getClassInfo());
                    classDao.addMember(myClass.getClassAdviser(), classId);
                    requestDao.updateRequest(request.getRequestId(), request.getRequestStatus());
                    return CommonUtil.successResult();
                }else{
                    return CommonUtil.failResult();
                }
            }else if(status == 3){
                requestDao.updateRequest(request.getRequestId(), request.getRequestStatus());
                return CommonUtil.failResult();
            }else{
                requestDao.deleteRequest(request.getRequestId());
            }
        }
        return CommonUtil.failResult();
    }


    @Override
    public JSONObject listRequestRegist(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = requestDao.countRequestRegist(jsonObject);
        List<JSONObject> list = requestDao.listRequestRegist(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject listRequestClass(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = requestDao.countRequestClass(jsonObject);
        List<JSONObject> list = requestDao.listRequestClass(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

}
