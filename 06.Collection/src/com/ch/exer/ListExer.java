package com.ch.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenpi
 * @create 2022-02-20 12:06
 */
public class ListExer {
    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);

    }

    private void updateList(List list){
        list.remove(2);//1 2
    }
}
