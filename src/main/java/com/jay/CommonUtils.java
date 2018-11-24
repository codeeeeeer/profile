package com.jay;

import java.util.Collection;
import java.util.Map;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/11/22 22:19
 */
public class CommonUtils {
    public static boolean isEmpty(Collection<?> collection){
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map){
        return map == null || map.isEmpty();
    }

    public static void assertTrue(boolean test, String message){
        if ( ! test){
            throw new IllegalStateException(message);
        }
    }

}
