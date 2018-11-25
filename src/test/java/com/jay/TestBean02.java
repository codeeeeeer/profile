package com.jay;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/11/25 10:57
 */
class TestBean02 {
    public static void test01() throws Exception {
        ProfileUtil.start("test01");
        test01_01();
        test01_02();
        test01_03();
        ProfileUtil.finish("test01");
    }

    public static void test02() throws Exception {
        ProfileUtil.start("test01");
        test01_01();
        test01_01();
        test01_02();
        test01_01();
        test01_02();
        test01_03();
        ProfileUtil.finish("test01");
    }

    public static void test01_01() throws Exception{
        ProfileUtil.start("test01_01");
        Thread.sleep(100);
        test01_01_01();
        Thread.sleep(200);
        test01_01_02();
        Thread.sleep(300);
        test01_01_03();
        ProfileUtil.finish("test01_01");
    }
    public static void test01_02() throws Exception {
        ProfileUtil.start("test01_02");
        Thread.sleep(100);
        test01_02_01();
        Thread.sleep(100);
        test01_02_02();
        Thread.sleep(100);
        test01_02_03();
        ProfileUtil.finish("test01_02");
    }
    public static void test01_03() throws Exception {
        ProfileUtil.start("test01_03");
        Thread.sleep(100);
        test01_03_01();
        ProfileUtil.finish("test01_03");
    }
    public static void test01_01_01() throws Exception {
        ProfileUtil.start("test01_01_01");
        Thread.sleep(100);
        ProfileUtil.finish("test01_01_01");
    }
    public static void test01_01_02() throws Exception {
        ProfileUtil.start("test01_01_02");
        Thread.sleep(100);
        ProfileUtil.finish("test01_01_02");
    }
    public static void test01_01_03() throws Exception {
        ProfileUtil.start("test01_01_03");
        Thread.sleep(100);
        ProfileUtil.finish("test01_01_03");
    }
    public static void test01_02_01() throws Exception {
        ProfileUtil.start("test01_02_01");
        Thread.sleep(100);
        ProfileUtil.finish("test01_02_01");
    }
    public static void test01_02_02() throws Exception {
        ProfileUtil.start("test01_02_02");
        Thread.sleep(100);
        ProfileUtil.finish("test01_02_02");
    }
    public static void test01_02_03() throws Exception {
        ProfileUtil.start("test01_02_03");
        Thread.sleep(100);
        ProfileUtil.finish("test01_02_03");
    }
    public static void test01_03_01() throws Exception {
        ProfileUtil.start("test01_03_01");
        Thread.sleep(100);
        ProfileUtil.finish("test01_03_01");
    }
}
