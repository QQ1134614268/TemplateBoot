package com.it.sim.itree;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Org implements Children {
    Integer id; //
    Integer parentId;
    String name;
    List<Org> children = new ArrayList<>();

    private Org(Integer id, Integer parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public static void main(String[] args) {
        Org Org1 = new Org(1, null, "1");
        Org Org2 = new Org(2, null, "2");
        Org Org3 = new Org(3, 2, "3");
        Org Org4 = new Org(4, 2, "4");
        ArrayList<Org> list = new ArrayList<>();
        list.add(Org1);
        list.add(Org2);
        list.add(Org3);
        list.add(Org4);
        List<Org> ret = Children.getTree(list);
        System.out.println(ret);
    }
}