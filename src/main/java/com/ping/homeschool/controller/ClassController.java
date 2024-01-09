package com.ping.homeschool.controller;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.Request;
import com.ping.homeschool.service.ClassService;
import com.ping.homeschool.service.RequestService;
import com.ping.homeschool.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class ClassController {
    @Autowired
    private ClassService classService;

    @Autowired
    private RequestService requestService;


    @RequiresPermissions("requestClass:add")
    @PostMapping("/requestClass")
    public JSONObject addClass(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        // requestType：2 --->代表创建班级请求类型
        Request request = new Request(null, 2, (short)1, new Date(), jsonObject.toJSONString());
//        request.setRequestTime(new Date());
        return requestService.addRequest(request);
    }

    @PostMapping("/requestJoinClass")
    public JSONObject joinClass(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        // requestType：3 --->代表申请加入班级请求类型
        Request request = new Request(null, 3, (short)1, new Date(), jsonObject.toJSONString());
        return requestService.addRequest(request);
    }

    @RequiresPermissions("class:delete")
    @GetMapping("/deleteClass/{classId}")
    public JSONObject deleteClass(@PathVariable("classId") int classId){
        return classService.deleteClass(classId);
    }


    @GetMapping("/selectClass/{classId}")
    public JSONObject selectClass(@PathVariable("classId") int classId){
        return classService.selectById(classId);
    }

    @RequiresPermissions("class:update")
    @PostMapping("/updateClassTop")
    public JSONObject updateClassTop(@RequestBody  JSONObject jsonObject){
        return classService.updateClass(jsonObject);
    }

    @GetMapping("/listClass")
    public JSONObject listClass(HttpServletRequest request){
        return classService.listClass(CommonUtil.request2Json(request));
    }

    @GetMapping("listMyClass/{userId}")
    public JSONObject listMyClass(@PathVariable("userId") int userId){
        return classService.listMyClass(userId);
    }

    @RequiresPermissions("classMember:delete")
    @PostMapping("/expelMember")
    public JSONObject expelMember(@RequestBody  JSONObject jsonObject){
        return classService.expelMember(jsonObject);
    }

    @PostMapping("/exitClass")
    public JSONObject exitClass(@RequestBody  JSONObject jsonObject){
        return classService.expelMember(jsonObject);
    }

    @GetMapping("listMember/{classId}")
    public JSONObject listMember(@PathVariable("classId") int classId){
        return classService.listMember(classId);
    }

    @PostMapping("class/isMember")
    public JSONObject isMember(@RequestBody JSONObject jsonObject){
        return classService.isMember(jsonObject);
    }

    @PostMapping("/addJoin")
    public JSONObject addJoin(@RequestBody JSONObject jsonObject){
        return classService.addJoin(jsonObject);
    }

    @RequiresPermissions("join:update")
    @PostMapping("/updateJoin")
    public JSONObject updateJoin(@RequestBody JSONObject jsonObject){
        return classService.updateJoin(jsonObject);
    }

    @RequiresPermissions("join:list")
    @GetMapping("/listJoin/{classAdviser}")
    public JSONObject listJoin(@PathVariable("classAdviser") int classAdviser){
        return classService.listJoin(classAdviser);
    }

    @PostMapping("/join/isDuplicate")
    public JSONObject checkJoin(@RequestBody JSONObject jsonObject){
        return classService.checkJoin(jsonObject);
    }
}
