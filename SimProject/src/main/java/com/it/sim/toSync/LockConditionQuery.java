package com.it.sim.toSync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 条件锁实现
 * @author binbin.hou
 * @since 1.0.0
 */
@Slf4j
public class LockConditionQuery extends AbstractQuery {


    private final Lock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    @Override
    protected void remoteCall() {
        lock.lock();
        try{
            super.remoteCall();

            log.info("远程线程执行完成，唤醒所有等待线程。");
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    @Override
    protected void endQuery() {
        lock.lock();
        try{
            // 等待
            log.info("主线程进入等待");

            condition.await();

            super.endQuery();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockConditionQuery query = new LockConditionQuery();
        query.asyncToSync();
    }

}