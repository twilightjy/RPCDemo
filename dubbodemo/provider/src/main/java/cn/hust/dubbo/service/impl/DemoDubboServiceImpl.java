package cn.hust.dubbo.service.impl;

import cn.hust.dubbo.service.DemoDubboService;
import org.apache.dubbo.config.annotation.Service;

//注意这里的@Service注解是apache Dubbo 的Service 标明这里是provider的service！而非consumer！
//要和Spring的@Service区分开来!!!
@Service
public class DemoDubboServiceImpl implements DemoDubboService {
    @Override
    public String demo(String param) {
        return param+"abc";
    }
}
