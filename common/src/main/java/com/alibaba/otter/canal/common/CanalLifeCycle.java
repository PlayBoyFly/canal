package com.alibaba.otter.canal.common;

/**
 * canal的生命周期接口
 * @author jianghang 2012-7-12 上午09:39:33
 * @version 1.0.0
 */
public interface CanalLifeCycle {

    void start();

    void stop();

    boolean isStart();
}
