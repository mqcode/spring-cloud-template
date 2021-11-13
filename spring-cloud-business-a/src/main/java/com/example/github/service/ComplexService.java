package com.example.github.service;

import java.util.Map;

public interface ComplexService {
    /**
     * 调用服务B
     * @return
     */
    Map aCallB();

    /**
     * 调用服务C
     * @return
     */
    Map aCallC();

    /**
     * A调用B,然后调C
     * @return
     */
    Map aCallBThenCallC();

    /**
     * A调用B,B中调C
     * @return
     */
    Map BCallCWhenACallB();
}
