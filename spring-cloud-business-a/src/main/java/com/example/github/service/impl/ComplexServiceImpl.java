package com.example.github.service.impl;

import com.example.github.feign.BusinessBFeign;
import com.example.github.feign.BusinessCFeign;
import com.example.github.service.ComplexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class ComplexServiceImpl implements ComplexService {

    @Resource
    private BusinessBFeign businessBFeign;

    @Resource
    private BusinessCFeign businessCFeign;

    @Override
    public Map aCallB() {
        return businessBFeign.callBAndGetResponse().getData();
    }

    @Override
    public Map aCallC() {
        return businessCFeign.callCAndGetResponse().getData();
    }

    @Override
    public Map aCallBThenCallC() {
        Map map = businessBFeign.callBAndGetResponse().getData();
        map.putAll(businessCFeign.callCAndGetResponse().getData());
        return map;
    }

    @Override
    public Map BCallCWhenACallB() {
        return businessBFeign.callBAndGetResponse().getData();
    }
}
