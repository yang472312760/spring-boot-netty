package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>@ProjectName:spring-boot-netty</p>
 * <p>@Package:com.yang.springbootnetty.controller</p>
 * <p>@ClassName:IndexController</p>
 * <p>@Description:${description}</p>
 * <p>@Author:yang</p>
 * <p>@Date:2020/1/6 16:03</p>
 * <p>@Version:1.0</p>
 */
@Controller
public class IndexController {

    @GetMapping("socket")
    public String index(Model model) {
        model.addAttribute("uid", (int) (Math.random() * (0.9 * (int) Math.pow(10, 6))) + (int) Math.pow(10, 6 - 1));
        return "socket/socket";
    }

}
