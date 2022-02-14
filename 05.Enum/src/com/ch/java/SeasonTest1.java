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

        //values():
        Season1[] values=Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        //valueof(String objName):返回枚举类中对象名是objName的对象；若没有，则抛异常：IllegalArgumentException
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);

    }
}
interface show{
    void show();
}

//使用enum关键字定义枚举类
enum Season1 implements show{
    //1.提供当前枚举类的对象，多个对象之间用","分开，末尾对象";"结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "寒冬腊月"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

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

}