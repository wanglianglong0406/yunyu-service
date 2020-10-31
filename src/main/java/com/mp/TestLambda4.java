package com.mp;

public class TestLambda4 {


    interface Param1{
        void outInfo(String info);

    }
    interface Param2{
        void outInfo(String info);

    }

    //定义重载方法
    public void lambdaMethod(Param1 param){
        param.outInfo("hello param1 ...");
    }


    public void lambdaMethod(Param2 param){
        param.outInfo("hello param2 ...");
    }


    public static void main(String[] args) {
        TestLambda4 testLambda4=new TestLambda4();
        testLambda4.lambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });

        testLambda4.lambdaMethod(new Param2() {
            @Override
            public void outInfo(String info) {

                System.out.println("-------------------");
                System.out.println(info);
            }
        });

        /**
         * lambda表达式存在类型检查 --> 自动推导lambda表达式目标类型
         * lambdaMethod() -方法 > 重载
         *        ->Param1  函数式接口
         *        ->Param2  函数式接口
         *
         *        调用方法 传递lambda表达式 ->自动推导->
         *        -> Param1 | Param2
         *
         */
      /*  testLambda4.lambdaMethod((String info)->{

        });*/

    }


}
