package com.ch.java;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * @author chenpi
 * @create 2022-02-09 20:40
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 sumber = Season1.SUMMER;
        System.out.println(sumber);
        System.out.println(Season1.class.getSuperclass());
    }
}
//使用enum关键字定义枚举类
enum Season1 {
    //1.提供当前枚举类的对象，多个对象之间用","分开，末尾对象";"结束
    SPRING("春天", "春暖花开"),
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "寒冬腊月");

    //2.声明Seanson对象的属性
    private final String seasonName;
    private final String seasonDesc;


    //3.私有化构造器,并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //4.其他诉求2：提供toString方法

//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

}