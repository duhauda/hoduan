package com.maccwok.xd.Controller;


import com.maccwok.xd.dto.LoginDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LoginController {
    @PostMapping("login")
    public  String login(@RequestBody LoginDTO loginDTO){
        System.out.println(loginDTO);
        return "注册成功";
    }

    @GetMapping("register")
    public String register(){
        return "register";
    }
    @GetMapping("getFruit")
    public ArrayList<String> getFruit(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("苹果");
        arrayList.add("香蕉");
        arrayList.add("西瓜");
        return arrayList;
    }
}
