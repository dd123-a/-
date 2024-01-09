package com.ping.homeschool.dao;

import com.alibaba.fastjson.JSONObject;
import com.ping.homeschool.model.MyClass;
import com.ping.homeschool.model.Request;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDao {

    /**
     * 新增班级【通过管理员系统请求】
     */
    int addClass(MyClass myClass);

    /**
     * 删除班级
     */
    int deleteClass(int classId);

    /**
     * 修改班级公告
     */
    int updateClassTop(int classId, String classTop);

    /**
     * 根据班级编码查询班级
     */
    MyClass selectById(int classId);

    /**
     * 统计班级数量
     */
    int countClass(JSONObject jsonObject);

    /**
     * 班级列表
     */
    List<JSONObject> listClass(JSONObject jsonObject);

    /**
     * 用户的班级列表
     */
    List<MyClass> listMyClass(int userId);

    /**
     * 新增班级成员【教师，家长】
     */
    int joinClass(@Param("userId") int userId, @Param("classId") int classId);

    /**
     * 开除班级成员/班级成员主动退出班级
     */
    int expelMember(@Param("userId") int userId, @Param("classId") int classId);

    /**
     * 班级成员列表
     */
    List<JSONObject> listMember(int classId);


    /**
     * 查询是否为班级成员
     */
    int isMember(@Param("userId") int userId, @Param("classId") int classId);

    /**
     * 添加班级成员
     */
    int addMember(@Param("userId") int userId, @Param("classId") int classId);

    /**
     * 根据班级名称及创建者及班级简介来查询班级编码
     */
    int queryByMany(@Param("className")String className, int classAdviser, @Param("classInfo")String classInfo);

    /**
     * 新增加入班级申请
     */
    int addJoin(JSONObject jsonObject);


    /**
     * 修改加入班级申请状态
     */
    int updateJoin(JSONObject jsonObject);

    /**
     * 加入班级申请列表
     */
    List<JSONObject> listJoin(int classAdviser);

    /**
     * 检查班级申请是否重复
     */
    int checkJoin(JSONObject jsonObject);
}
