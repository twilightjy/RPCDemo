package cn.hust.service.impl;

import cn.hust.dubbo.service.DemoDubboService;
import cn.hust.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/*
注解consumer的@Service用的是spring的，标明这里是一般的mvc提供service层服务的地方
 */
@Service
public class DemoServiceImpl implements DemoService {

    //注意这里也是apache Dubbo 的注解哦！
    @Reference
    private DemoDubboService demoDubboService;

    @Override
    public String demo(String param) {
        //利用Dubbo进行远程调用
        return demoDubboService.demo(param);
    }
}
