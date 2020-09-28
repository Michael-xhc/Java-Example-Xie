package cn.com.sinosafe.xieapi.testcontroller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by xiehanchun on 2020/9/28
 */
public class TestClass {

    public void sortAg(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(30);
        list.add(23);
        list.add(48);

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2) return 1;
                else return -1;
            }
        };

        Collections.sort(list,c);

        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
