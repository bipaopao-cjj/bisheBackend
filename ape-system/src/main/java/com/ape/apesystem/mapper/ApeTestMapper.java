package com.ape.apesystem.mapper;

import com.ape.apesystem.domain.ApeTest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 
 * @version 1.0
 * @description: 考试mapper
 * 
 */
public interface ApeTestMapper extends BaseMapper<ApeTest> {
    Map<String,Object> getStudentTotalScore(@Param("taskId") String taskId,@Param("userId") String userId);
}