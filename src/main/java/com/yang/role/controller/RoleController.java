package com.yang.role.controller;

import com.svw.ematrix.base.vo.Result;
import com.svw.ematrix.log.annotation.SystemLog;
import com.svw.ematrix.log.enums.LogType;
import com.svw.ematrix.log.enums.OperateType;
import com.yang.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@ProjectName:spring-boot-netty</p>
 * <p>@Package:com.yang.springbootnetty.role.controller</p>
 * <p>@ClassName:RoleController</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2019/12/21 15:42</p>
 * <p>@Version:1.0</p>
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @SystemLog(logType = LogType.BUSINESSLOG, operateType = OperateType.SELECT, valueIsTemplate = false, logContent = "hello")
    @GetMapping("/list")
    public Result getList() {
        return new Result().setData(this.roleService.selectList());
    }

}
