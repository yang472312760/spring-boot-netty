package com.yang.role.service;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>@ProjectName:spring-boot-netty</p>
 * <p>@Package:com.yang.springbootnetty.role.service</p>
 * <p>@ClassName:RoleService</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2019/12/21 15:35</p>
 * <p>@Version:1.0</p>
 */
public interface RoleService<Role> extends IService {

    public List<Role> selectList();

}
