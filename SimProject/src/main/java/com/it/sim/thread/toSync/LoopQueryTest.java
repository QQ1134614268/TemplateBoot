package com.it.sim.thread.toSync;

import com.it.sim.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 循环等待
 * @author binbin.hou
 * @since 1.0.0
 */
@Slf4j
public class LoopQueryTest extends AbstractQuery {


    @Override
    protected void endQuery() {
        try {
            while (StringUtil.isEmpty(result)) {
                //循环等待一下
                TimeUnit.MILLISECONDS.sleep(10);
            }

            //获取结果

            log.info("完成查询，结果为：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        LoopQueryTest loopQueryTest = new LoopQueryTest();
        loopQueryTest.asyncToSync();
    }
}