package com.jay;

import junit.framework.TestCase;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/11/23 21:19
 */
public class TestProfileUtil extends TestCase {
    @Override
    protected void setUp() throws Exception {
        ProfileUtil.init();
    }

    public void testException(){
        try {
            ProfileUtil.finish("test01");
            CommonUtils.assertTrue(false, "will never reach here");
        }catch (Exception exception){
            assertTrue(exception instanceof IllegalStateException);
            assertEquals(exception.getMessage(), "stack monitor is already empty");
        }
    }

    public void testException_02(){
        ProfileUtil.start("test00");
        try {
            ProfileUtil.finish("test01");
            CommonUtils.assertTrue(false, "will never reach here");
        }catch (Exception exception){
            assertTrue(exception instanceof IllegalStateException);
            assertEquals(exception.getMessage(), "the closing method （test01） is not the current method name（test00）");
        }
    }

    public void testNormal_01(){
        /**
         * 	test00 was called 2 times, cost 0 ms
         * 		test01 was called 1 times, cost 0 ms
         * 			test02 was called 1 times, cost 0 ms
         */
        ProfileUtil.start("test00");
        ProfileUtil.finish("test00");
        ProfileUtil.start("test00");
        ProfileUtil.start("test01");
        ProfileUtil.start("test02");
        ProfileUtil.finish("test02");
        ProfileUtil.finish("test01");
        ProfileUtil.finish("test00");
        ProfileUtil.printSta();

    }

    public void testNormal_02() throws Exception{
        /**
         *	test00 was called 2 times, cost 73 ms
         * 		test01 was called 1 times, cost 17 ms
         * 			test02 was called 1 times, cost 11 ms
         */
        ProfileUtil.start("test00");
        Thread.sleep(50);
        ProfileUtil.finish("test00");
        ProfileUtil.start("test00");
        Thread.sleep(5);
        ProfileUtil.start("test01");
        Thread.sleep(5);
        ProfileUtil.start("test02");
        Thread.sleep(10);
        ProfileUtil.finish("test02");
        ProfileUtil.finish("test01");
        ProfileUtil.finish("test00");
        ProfileUtil.printSta();

    }
}
