package com.ping.homeschool.controller;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.Request;
import com.ping.homeschool.service.RequestService;
import com.ping.homeschool.service.UserService;
import com.ping.homeschool.util.CommonUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;



@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private RequestService requestService;
	/**
	 * 查询用户名（数量）
	 */
	@RequestMapping("/queryByUsername/{username}")
	public JSONObject queryUsername(@PathVariable("username") String username) throws UnsupportedEncodingException {
		// 对数据先进行解码
		username = URLDecoder.decode(username, "utf-8");
		return userService.queryByUsername(username);
	}

	/**
	 * 根据用户名查询获得用户信息（具体信息）
	 */
	@RequestMapping("/queryUser/{username}")
	public JSONObject queryUser(@PathVariable("username") String username) throws UnsupportedEncodingException {
		// 对数据先进行解码
		username = URLDecoder.decode(username, "utf-8");
		return userService.queryUser(username);
	}
	/**
	 * 查询用户列表
	 */
	@RequiresPermissions("user:list")
	@GetMapping("/user/list")
	public JSONObject listUser(HttpServletRequest request) {
		return userService.listUser(CommonUtil.request2Json(request));
	}

	/**
	 * （家长）用户注册
	 */
	@PostMapping("/addUser")
	public JSONObject addUser(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "username, password, nickname, phone");
		return userService.addUser(requestJson);
	}

	/**
	 * 发送教师账号注册请求
	 */
	@PostMapping("/requestRegist")
	public JSONObject addTeacher(@RequestBody JSONObject jsonObject){
		System.out.println(jsonObject);
		Request request = new Request(null, 1, (short)1, null, jsonObject.toJSONString());
		request.setRequestTime(new Date());
		return requestService.addRequest(request);
	}

	@RequiresPermissions("user:update")
	@PostMapping("/user/updateUser")
	public JSONObject updateUser(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, " nickname,   roleId, deleteStatus, userId");
		return userService.updateUser(requestJson);
	}

	@RequiresPermissions(value = {"user:add", "user:update"}, logical = Logical.OR)
	@GetMapping("/user/getAllRoles")
	public JSONObject getAllRoles() {
		return userService.getAllRoles();
	}

	/**
	 * 角色列表
	 */
	@RequiresPermissions("role:list")
	@GetMapping("/user/listRole")
	public JSONObject listRole() {
		return userService.listRole();
	}

	/**
	 * 查询所有权限, 给角色分配权限时调用
	 */
	@RequiresPermissions("role:list")
	@GetMapping("/user/listAllPermission")
	public JSONObject listAllPermission() {
		return userService.listAllPermission();
	}

	/**
	 * 新增角色
	 */
	@RequiresPermissions("role:add")
	@PostMapping("/user/addRole")
	public JSONObject addRole(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "roleName,permissions");
		return userService.addRole(requestJson);
	}

	/**
	 * 修改角色
	 */
	@RequiresPermissions("role:update")
	@PostMapping("/user/updateRole")
	public JSONObject updateRole(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "roleId,roleName,permissions");
		return userService.updateRole(requestJson);
	}

	/**
	 * 删除角色
	 */
	@RequiresPermissions("role:delete")
	@PostMapping("/user/deleteRole")
	public JSONObject deleteRole(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "roleId");
		return userService.deleteRole(requestJson);
	}
}
