package com.ping.homeschool.controller;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.SystemNotice;
import com.ping.homeschool.service.SystemNoticeService;
import com.ping.homeschool.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/systemNotice")
public class SystemNoticeController {
    @Autowired
    private SystemNoticeService systemNoticeService;

    @RequiresPermissions("systemNotice:add")
    @PostMapping("/addSystemNotice")
    public JSONObject addSystemNotice(@RequestBody SystemNotice systemNotice){
        return systemNoticeService.addSystemNotice(systemNotice);
    }

    @RequiresPermissions("systemNotice:delete")
    @GetMapping("/delete/{systemNoticeId}")
    public JSONObject deleteSystemNotice(@PathVariable int systemNoticeId){
        return systemNoticeService.deleteSystemNotice(systemNoticeId);
    }

    @GetMapping("/selectSystemNotice/{systemNoticeId}")
    public JSONObject selectById(@PathVariable int systemNoticeId){
        return systemNoticeService.selectById(systemNoticeId);
    }

    @RequiresPermissions("systemNotice:list")
    @GetMapping("/list")
    public JSONObject listSystemNotice(HttpServletRequest request){
        return systemNoticeService.listSystemNotice(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("systemNotice:list")
    @GetMapping("/listAll")
    public JSONObject listAll(){
        return systemNoticeService.listAll();
    }
}
