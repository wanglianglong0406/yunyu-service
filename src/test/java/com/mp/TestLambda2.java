package com.mp;

public class TestLambda2 {
    String s1="全局变量";
    public void testInterClass(){
        String s2="局部变量";
        new Thread(new Runnable() {
            String s3="内部变量";

            @Override
            public void run() {
                //访问全局变量
                //System.out.println(this.s1);//this关键字表示当前内部类的对象
                System.out.println(s1);
                System.out.println(s2);//局部变量的访问不能局部变量进行数据修改 final
               // s2="hell";

                System.out.println(s3);
                System.out.println(this.s3);

            }
        }).start();
    }

    public void testLambda(){
        String s2="局部变量lambda";
        new Thread(()->{
            String s3="内部变量lambda";
            //访问全局变量
            System.out.println(this.s1); //this关键字表示的就是所属方法所在类型的对象

            //访问局部变量
            System.out.println(s2);//不能进行数据修改，默认推导变量的修饰符 final
            s3="lambdan内部变量直接修改";
            System.out.println(s3);

        }).start();
    }

    public static void main(String[] args) {
        TestLambda2 testLambda2 =new TestLambda2();
       // testLambda2.testInterClass();

        testLambda2.testLambda();
    }
}
