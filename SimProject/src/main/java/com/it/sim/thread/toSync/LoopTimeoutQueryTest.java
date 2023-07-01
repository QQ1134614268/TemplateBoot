package com.it.sim.thread.toSync;

import com.it.sim.util.StringUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 循环等待-包含超时时间
 * @author binbin.hou
 * @since 1.0.0
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper = true)
public class LoopTimeoutQueryTest extends AbstractQuery {


    /**
     * 超时时间
     */
    private long timeoutMills = 3000;

    public LoopTimeoutQueryTest() {
    }

    @Override
    protected void endQuery() {
        try {
            final long endTimeMills = System.currentTimeMillis() + timeoutMills;

            while (StringUtil.isEmpty(result)) {
                // 超时判断
                if(System.currentTimeMillis() >= endTimeMills) {
                    throw new RuntimeException("请求超时");
                }

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
        LoopTimeoutQueryTest loopQuery = new LoopTimeoutQueryTest();
        loopQuery.asyncToSync();
    }
}