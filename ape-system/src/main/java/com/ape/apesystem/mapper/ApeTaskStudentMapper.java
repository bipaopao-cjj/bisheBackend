package com.ape.apesystem.mapper;

import com.ape.apesystem.domain.ApeTaskStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * @version 1.0
 * @description: 课程报名mapper
 * 
 */
public interface ApeTaskStudentMapper extends BaseMapper<ApeTaskStudent> {
    List<Map<String, Object>> selectTopTaskChart(@Param("teacherId") String teacherId);
}