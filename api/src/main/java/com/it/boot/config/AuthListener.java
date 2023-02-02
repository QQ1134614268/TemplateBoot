package com.it.boot.config;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * request 系统级别 请求构造，初始化，销毁 的监听。
 */
@WebListener
public class AuthListener implements ServletRequestListener {

    /**
     * Default constructor.
     */
    public AuthListener() {
        System.err.println("ServletListener===========ServletListener()");
    }

    /**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0) {

        System.err.println("ServletListener========requestDestroyed(ServletRequestEvent arg0)");
    }

    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0) {

        System.err.println("ServletListener=============requestInitialized(ServletRequestEvent arg0)");
    }

}
