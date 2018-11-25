package com.jay;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/11/25 12:26
 */
class ProfileThread implements Runnable {

    @Override
    public void run() {
        ProfileUtil.init();
        try {
            TestBean02.test01();
        }catch (Exception exception){
            //eat exception
        }finally {
            ProfileUtil.printSta();
        }
    }
}
