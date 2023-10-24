package com.maccwok.xd.Controller;


import cn.hutool.core.util.StrUtil;
import com.maccwok.xd.dto.LoginDTO;
import com.maccwok.xd.dto.RegisterDTO;
import com.maccwok.xd.entity.UserEntity;
import com.maccwok.xd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LoginController {
    @Autowired private UserService userService;
    @PostMapping("login")
    public  String login(@RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO);
        return "11";
    }

    @PostMapping("register")
    public String register(@RequestBody RegisterDTO registerDTO){
    String account = registerDTO.getAccount();
    String password = registerDTO.getPassword();
    String password1 = registerDTO.getPassword1();
       if( StrUtil.isEmpty(account)||StrUtil.isEmpty(password)||StrUtil.isEmpty(password1)) {
           return "数据校验不通过";
       }
        if(!password1.equals(password)){
            return "第一次密码与第二次密码不一致";
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setAccount(account);
        userEntity.setPassword(password);
        userService.save(userEntity);
        System.out.println(registerDTO);
        return "register";
    }
    @GetMapping("getFruit")
    public ArrayList<String> getFruit(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("苹果");
        arrayList.add("香蕉");
        arrayList.add("芒果");
        arrayList.add("666");
        return arrayList;
    }
}
