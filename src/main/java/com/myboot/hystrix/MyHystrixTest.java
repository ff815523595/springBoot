package com.myboot.hystrix;

/**
 * Created by a on 2017/10/10.
 */
public class MyHystrixTest {

    public static void main(String[] args) {
        final HystrixUtil hystrixUtil = new HystrixUtil();


        for (int i = 0; i < 10; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    System.out.println(hystrixUtil.execute("service" , "getTest" , "/service/getTest/1.do"));
                }
            };
            t.start();
        }


    }
}
