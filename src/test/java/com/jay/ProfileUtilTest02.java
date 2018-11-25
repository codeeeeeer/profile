package com.jay;

import junit.framework.TestCase;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/11/25 10:53
 */
public class ProfileUtilTest02 extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ProfileUtil.init();
    }

    public void testBean02() throws Exception{
        TestBean02.test01();

        //方法的层级调用会形成一个树结构，可以无限增加树的层级
        //某一个方法(A)，调用其他方法(B,C,D等)，其他方法就是这个方法的下一级节点(A方法是B,C,D方法的共同父节点)
        //如果方法A递归调用自身，则会在A节点增加一个子节点A'.

        /**
         * 	test01 was called 1 times, cost 1816 ms
         * 		test01_03 was called 1 times, cost 218 ms
         * 			test01_03_01 was called 1 times, cost 109 ms
         * 		test01_02 was called 1 times, cost 656 ms
         * 			test01_02_03 was called 1 times, cost 109 ms
         * 			test01_02_01 was called 1 times, cost 109 ms
         * 			test01_02_02 was called 1 times, cost 109 ms
         * 		test01_01 was called 1 times, cost 940 ms
         * 			test01_01_01 was called 1 times, cost 100 ms
         * 			test01_01_03 was called 1 times, cost 109 ms
         * 			test01_01_02 was called 1 times, cost 109 ms
         */
    }

    public void testBean02_test02() throws Exception{
        TestBean02.test02();

        //多次调用一个方法时，会将调用次数和调用时间进行累加

        /**
         * 	test01 was called 1 times, cost 4382 ms
         * 		test01_03 was called 1 times, cost 218 ms
         * 			test01_03_01 was called 1 times, cost 109 ms
         * 		test01_02 was called 2 times, cost 1312 ms
         * 			test01_02_03 was called 2 times, cost 219 ms
         * 			test01_02_01 was called 2 times, cost 219 ms
         * 			test01_02_02 was called 2 times, cost 219 ms
         * 		test01_01 was called 3 times, cost 2851 ms
         * 			test01_01_01 was called 3 times, cost 331 ms
         * 			test01_01_03 was called 3 times, cost 334 ms
         * 			test01_01_02 was called 3 times, cost 329 ms
         */
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        ProfileUtil.printSta();
    }
}
