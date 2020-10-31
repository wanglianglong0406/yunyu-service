package com.mp;

import java.util.ArrayList;
import java.util.List;

public class TestLambda3 {
    public static void main(String[] args) {

       test(new MyInterface<String, List>() {
           @Override
           public List strategy(String s, List list) {
               list.add(s);

               return list;
           }
       });

       test((x,y)->{
           y.add(x);
           return y;
       });

        /**
         * （x,y）->{}  -->test(param) -->=MyInterface -->lambda表达式 ->MyInterface类型这个就是对lambda表达式类型检查
         * MyInterface接口就是lambda表达式的目标类型（target typing）
         * 
         * (x,y) ->{..} -->MyInterface.strategy(T t,R r) --> MyInterface<String,List> inter
         *  --> T==String R=List --> lambda--> (x,y)--{..} ==strategy(T t,R r) --> x==T==String y==R==list
         *  lambda 表达式类型检查
         */
    }

    public static void test(MyInterface<String,List> inter){
        List<String> list=inter.strategy("hello",new ArrayList());
        System.out.println(list);
    }
}

@FunctionalInterface
interface MyInterface<T,R>{
    R strategy(T t,R r);
}
