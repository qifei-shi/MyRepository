package com.kuang.dao;


import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    //测试：查询所有老师
//    List<Teacher> getTeacher();

    //获取指定老师下所有学生的信息
    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);

}
