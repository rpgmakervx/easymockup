package org.easyarch.easymockup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(5);
        list.add(10);
        Collections.sort(list);
        System.out.println(list);
    }
}
