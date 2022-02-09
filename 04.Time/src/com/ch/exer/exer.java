package com.ch.exer;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * 练习题
 *
 * @author chenpi
 * @create 2022-02-09 19:01
 */
public class exer {
    /*
    1.将字符串"2022-02-09" 转化位对应的 java.sql.Date类对象
    jdk8之前或jdk8皆可
     */
    @Test
    public void test1() throws ParseException {

        //jdk8之前
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //解析
        Date date = sdf.parse("2022-02-09");

        //jdk8
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    }

   /*
    2.何为编码？解码？何为日期时间的格式化？解析？
    编码：字符串——（某字符集）——>字节数据
    解码：字节——（某字符集）——>字符串

    格式化：日期——>字符串
    解析：字符串——>日期
     */

    /*
    3.自定义Person类，实现自然排序（按姓名升序）
     */
    @Test
    public void test2() {

        Persion[] arr = new Persion[5];
        arr[0] = new Persion("Tom", 25);
        arr[1] = new Persion("Jerry", 28);
        arr[2] = new Persion("Bob", 18);
        arr[3] = new Persion("Amy", 34);
        arr[4] = new Persion("Tom", 22);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /*
   4.提供定制排序涉及到的接口实现类对象，并按Person类的年龄降序。
    */
    @Test
    public void test3() {

        Persion[] arr = new Persion[5];
        arr[0] = new Persion("Tom", 25);
        arr[1] = new Persion("Jerry", 28);
        arr[2] = new Persion("Bob", 18);
        arr[3] = new Persion("Amy", 34);
        arr[4] = new Persion("Tom", 22);

        Arrays.sort(arr, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Persion && o2 instanceof Persion) {
                    Persion p1 = (Persion) o1;
                    Persion p2 = (Persion) o2;

                    if (p1.getAge() > p2.getAge()) {
                        return -1;
                    } else if (p1.getAge() < p2.getAge()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }

                throw new RuntimeException("类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));

    }
}
