
package com.it.sim.design;

/**
 * 定义端口接口，提供通信服务
 */
interface Port {
    /**
     * 远程SSH端口为22
     */
    void SSH();

    /**
     * 网络端口为80
     */
    void NET();

    /**
     * Tomcat容器端口为8080
     */
    void Tomcat();

    /**
     * MySQL数据库端口为3306
     */
    void MySQL();
}

/**
 * 定义抽象类实现端口接口，但是什么事情都不做
 */
abstract class Wrapper implements Port {
	@Override
	public void SSH() {

	}

	@Override
	public void NET() {

	}

    @Override
    public void Tomcat() {

    }

    @Override
    public void MySQL() {

    }
}

/**
 * 提供聊天服务 需要网络功能
 */
class Chat extends Wrapper {
    @Override
    public void NET() {
        System.out.println("Hello World...");
    }
}

/**
 * 网站服务器 需要Tomcat容器，Mysql数据库，网络服务，远程服务
 */
class Server extends Wrapper {
    @Override
    public void SSH() {
        System.out.println("Connect success...");
    }

    @Override
    public void NET() {
        System.out.println("WWW...");
    }

    @Override
    public void Tomcat() {
        System.out.println("Tomcat is running...");
    }

    @Override
    public void MySQL() {
        System.out.println("MySQL is running...");
    }
}

/**
 * 接口的适配器是这样的：有时我们写的一个接口中有多个抽象方法，当我们写该接口的实现类时，必须实现该接口的所有方法，这明显有时比较浪费，因为并不是所有的方法都是我们需要的
 * 有时只需要某一些，此处为了解决这个问题，我们引入了接口的适配器模式，借助于一个抽象类，该抽象类实现了该接口，实现了所有的方法，而我们不和原始的接口打交道，
 * 只和该抽象类取得联系，所以我们写一个类，继承该抽象类，重写我们需要的方法就行。
 */
public class AdapterInterface {

    private static Port chatPort = new Chat();
    private static Port serverPort = new Server();

    public static void main(String[] args) {
        // 聊天服务
        chatPort.NET();

        // 服务器
        serverPort.SSH();
        serverPort.NET();
        serverPort.Tomcat();
        serverPort.MySQL();
    }
}