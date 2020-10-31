package com.mp;

public class TestLambda {

    public static void main(String[] args) {



        //lambda表达式的基本语法
       /*
       * 申明：就是lambda绑定的接口类型
       * 参数：包含在--对圆括号和百年规定的接口中的抽象方法中的参数个数及顺序一致
       * 操作符： ->
       * 执行代码块：包含在一对大括号中，出下载操作符的右侧
       * 接口申明=参数 ->{执行代码块}
       *
       * */

        ILambda1 ilambda1=() ->{
            System.out.println("hello imooc!");
            System.out.println("welcome to imooc");
        };
        ilambda1.test();

        ILambda1 iLambda11=()->System.out.println("hello imooc!");
        iLambda11.test();

        ILambda2 iLambda2=(String a,int b)->{
            System.out.println(a+"say:my years old is "+b);
        };

        iLambda2.test("jack",12);

        ILambda2 iLambda22=(a,b)->{
            System.out.println(a+"say:my years old is "+b);
        };
        iLambda22.test("jack",12);

        ILambda3 iLambda3=(x,y)->{
            int z=x+y;
            return z;
        };
        System.out.println(iLambda3.test(12,14));
        ILambda3 iLambda31=(x,y)->x+y;
        System.out.println(iLambda31.test(10,20));

        /**
         * lambda表达式必须和接口进行绑定
         * lambda表达式的参数，可以附带0个到n个参数，括号中的参数类型可以不用指定，jvm在运行时，会自动根据绑定的抽象方法中的参数进行推导
         * lambda表达式的返回值，如果代码块只有一行，并且没有大括号，不用写return关键字，胆寒代码的执行结果会自动返回
         *    如果添加了大括号，或者有多行代码，必须通过return关键字返回结果
         */

    }
    //没有参数没有返回值的lambda表达式绑定的接口
    interface ILambda1{
        void test();
    }


    //带有参数，没有返回值
    interface ILambda2{
        void test(String a ,int b);
    }

    //带有参数，带有返回值的lambda表达式

    interface ILambda3{
        int test(int x,int y);
    }

}
