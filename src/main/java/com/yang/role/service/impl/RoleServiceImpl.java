package com.yang.role.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.role.mapper.RoleMapper;
import com.yang.role.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>@ProjectName:spring-boot-netty</p>
 * <p>@Package:com.yang.springbootnetty.role.service.impl</p>
 * <p>@ClassName:RoleServiceImpl</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2019/12/21 15:35</p>
 * <p>@Version:1.0</p>
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List selectList() {

        return roleMapper.selectList();
    }
}
