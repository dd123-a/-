package com.ping.homeschool.controller;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.ClassNotice;
import com.ping.homeschool.service.ClassNoticeService;
import com.ping.homeschool.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/classNotice")
public class ClassNoticeController {
    @Autowired
    private ClassNoticeService classNoticeService;

    @RequiresPermissions("classNotice:add")
    @PostMapping("/addClassNotice")
    public JSONObject addSystemNotice(@RequestBody ClassNotice classNotice){
        return classNoticeService.addClassNotice(classNotice);
    }

    @RequiresPermissions("classNotice:delete")
    @GetMapping("/delete/{classNoticeId}")
    public JSONObject deleteSystemNotice(@PathVariable("classNoticeId") int classNoticeId){
        return classNoticeService.deleteClassNotice(classNoticeId);
    }

    @GetMapping("/selectClassNotice/{classNoticeId}")
    public JSONObject selectById(@PathVariable("classNoticeId")  int classNoticeId){
        return classNoticeService.selectById(classNoticeId);
    }

    @RequiresPermissions("classNotice:list")
    @GetMapping("/list")
    public JSONObject listSystemNotice(HttpServletRequest request){
        return classNoticeService.listClassNotice(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("classNotice:list")
    @GetMapping("/listAll/{classId}")
    public JSONObject listAll(@PathVariable int classId){
        return classNoticeService.listAll(classId);
    }

    @PostMapping("/search")
    public JSONObject searchClassNotice(@RequestBody JSONObject jsonObject){
        return classNoticeService.queryByMany(jsonObject);
    }
}
