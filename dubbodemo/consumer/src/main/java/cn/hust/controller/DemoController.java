package cn.hust.controller;

import cn.hust.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyer/order")
public class DemoController {

    @Autowired
    private DemoService demoService;
    
    @GetMapping("/demo1/{param}")
    public String demo(@PathVariable String param){
        return demoService.demo(param);
    }

}
