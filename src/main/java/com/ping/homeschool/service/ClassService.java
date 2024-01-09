package com.ping.homeschool.service;

import com.alibaba.fastjson.JSONObject;

public interface ClassService {

    JSONObject deleteClass(int classId);

    JSONObject updateClass(JSONObject jsonObject);

    JSONObject selectById(int classId);

    JSONObject listClass(JSONObject jsonObject);

    JSONObject listMyClass(int userId);

    JSONObject expelMember(JSONObject jsonObject);

    JSONObject exitClass(JSONObject jsonObject);

    JSONObject listMember(int classId);

    JSONObject isMember(JSONObject jsonObject);

    JSONObject addJoin(JSONObject jsonObject);

    JSONObject updateJoin(JSONObject jsonObject);

    JSONObject listJoin(int userId);

    JSONObject checkJoin(JSONObject jsonObject);
}
