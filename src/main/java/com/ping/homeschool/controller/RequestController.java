package com.ping.homeschool.controller;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.Request;
import com.ping.homeschool.service.RequestService;
import com.ping.homeschool.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 系统请求controller
 */
@RestController
@RequestMapping("/request")
public class RequestController {
    @Autowired
    private RequestService requestService;

    // 查看所有账号注册请求
    @RequiresPermissions("requestRegist:list")
    @GetMapping("/listRegist")
    public JSONObject listRequestRegist(HttpServletRequest request){
        return requestService.listRequestRegist(CommonUtil.request2Json(request));
    }

    // 查看所有班级创建请求
    @RequiresPermissions("requestClass:list")
    @GetMapping("/listClass")
    public JSONObject listRequestClass(HttpServletRequest request){
        return requestService.listRequestClass(CommonUtil.request2Json(request));
    }

    // 删除请求
    @RequiresPermissions("request:delete")
    @GetMapping("/deleteRequest/{requestId}")
    public JSONObject deleteRequest(@PathVariable("requestId") Integer requestId){
        return requestService.deleteRequest(requestId);
    }

    // 修改注册请求
    @RequiresPermissions("requestRegist:update")
    @PostMapping("/updateRequestRegist")
    public JSONObject updateRequestRegist(@RequestBody Request request){
        return requestService.updateRequestRegist(request);
    }

    // 修改班级请求
    @RequiresPermissions("requestClass:update")
    @PostMapping("/updateRequestClass")
    public JSONObject updateRequestClass(@RequestBody Request request){
        return requestService.updateRequestClass(request);
    }
}
