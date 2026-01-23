package com.ape.apesystem.service.impl;

import com.ape.apesystem.domain.ApeForumItem;
import com.ape.apesystem.mapper.ApeForumItemMapper;
import com.ape.apesystem.service.ApeForumItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * @version 1.0
 * @description: 论坛讨论service实现类
 *
 */
@Service
public class ApeForumItemServiceImpl extends ServiceImpl<ApeForumItemMapper, ApeForumItem> implements ApeForumItemService {
}