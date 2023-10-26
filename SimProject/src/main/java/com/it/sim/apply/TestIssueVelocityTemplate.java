package com.it.sim.apply;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringWriter;
import java.net.URL;
import java.util.Properties;

public class TestIssueVelocityTemplate {
    @Test
    public void test0() {
        String basePath = "header";
        URL resource = TestIssueVelocityTemplate.class.getResource("");
        Assert.assertNotNull(resource);
        String sysRoot = resource.getPath();
        Properties properties = new Properties();
        // 设置velocity资源加载方式为file
        properties.setProperty("resource.loader", "file");
        // 设置velocity资源加载方式为file时的处理类
        properties.setProperty("resource.loader.file.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        properties.put("input.encoding", "UTF-8");
        properties.put("output.encoding", "UTF-8");
        // 实例化一个VelocityEngine对象
        VelocityEngine velocityEngine = new VelocityEngine(properties);
        // 实例化一个VelocityContext
        VelocityContext velocityContext = new VelocityContext();
        // 向VelocityContext中放入键值
        velocityContext.put("username", "张三");
        velocityContext.put("password", "123456789");
        velocityContext.put("age", "20");
        // 实例化一个StringWriter
        StringWriter writer = new StringWriter();
        Template template = velocityEngine.getTemplate(sysRoot + basePath, "UTF-8");
        template.merge(velocityContext, writer);
        System.out.println(writer);
    }

    @Test
    public void test1() {
        VelocityContext context = new VelocityContext();
        context.put("name", "Velocity");

        Properties p = new Properties();
        p.setProperty("file.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(p);

        Template template = Velocity.getTemplate("header.vm");
        StringWriter writer = new StringWriter();

        template.merge(context, writer);
        System.out.println(writer);
    }

    @Test
    public void test2() {
        Properties p = new Properties();
        p.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, "");
        Velocity.init(p);
        Template template = Velocity.getTemplate("D:\\workspace\\demos\\TemplateBoot\\SimProject\\src\\main\\resources\\header.vm");
        StringWriter writer = new StringWriter();

        VelocityContext context = new VelocityContext();
        context.put("name", "Velocity");
        template.merge(context, writer);
        System.out.println(writer);
    }


}