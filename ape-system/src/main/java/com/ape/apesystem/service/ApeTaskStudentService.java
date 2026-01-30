package com.ape.apesystem.service;

import com.ape.apesystem.domain.ApeTaskStudent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 
 * @version 1.0
 * @description: 课程报名service
 * 
 */
public interface ApeTaskStudentService extends IService<ApeTaskStudent> {
    List<Map<String, Object>> selectTopTaskChart(String teacherId);
}