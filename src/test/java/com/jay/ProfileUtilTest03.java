package com.jay;

import junit.framework.TestCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/11/25 12:23
 */
public class ProfileUtilTest03{
    private static final Integer threads = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executorService.execute( ()-> {
                ProfileUtil.init();
                try {
                    ProfileUtil.start("test01");
                    Thread.sleep(10);
                    ProfileUtil.start("test02");
                    Thread.sleep(100);
                    ProfileUtil.finish("test02");
                    ProfileUtil.finish("test01");
                }catch (Exception exception){
                    //eat exception
                }finally {
                    ProfileUtil.printSta();
                }
            });
        }

        //如果是多线程环境，各个线程的profile树不会相互影响
        //因为profile树是用ThreadLocal存储在线程本地的

        /**
         * 2018-11-25 12:38:24,595 [pool-1-thread-2] INFO  [com.jay.ProfileUtil] -
         * 	test01 was called 1 times, cost 119 ms
         * 		test02 was called 1 times, cost 115 ms
         *
         * 2018-11-25 12:38:24,595 [pool-1-thread-1] INFO  [com.jay.ProfileUtil] -
         * 	test01 was called 1 times, cost 119 ms
         * 		test02 was called 1 times, cost 115 ms
         *
         * 2018-11-25 12:38:24,595 [pool-1-thread-5] INFO  [com.jay.ProfileUtil] -
         * 	test01 was called 1 times, cost 119 ms
         * 		test02 was called 1 times, cost 116 ms
         *
         * 2018-11-25 12:38:24,595 [pool-1-thread-3] INFO  [com.jay.ProfileUtil] -
         * 	test01 was called 1 times, cost 119 ms
         * 		test02 was called 1 times, cost 115 ms
         *
         * 2018-11-25 12:38:24,595 [pool-1-thread-4] INFO  [com.jay.ProfileUtil] -
         * 	test01 was called 1 times, cost 119 ms
         * 		test02 was called 1 times, cost 116 ms
         */
    }

}
