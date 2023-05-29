package com.it.sim.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

public class Test {

    @JacksonXmlRootElement(localName = "teacher")
    public static class Teacher {

        @JacksonXmlProperty(localName = "name")
        String name;

        @JacksonXmlElementWrapper(localName = "students")
        List<Student> students;

    }


    @JacksonXmlRootElement(localName = "teacher")
    public static class Student {
        @JacksonXmlProperty(localName = "name")
        String name;
    }

    public static void main(String[] args) {

    }
}
