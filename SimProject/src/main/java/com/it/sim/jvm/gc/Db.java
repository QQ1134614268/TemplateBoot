package com.it.sim.jvm.gc;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
class Db {
    public static Map<String, ClassA> map = new ConcurrentHashMap<>();
    public static List<String> list = new ArrayList<>();
    public static List<Integer> listInt = new ArrayList<>();
}
