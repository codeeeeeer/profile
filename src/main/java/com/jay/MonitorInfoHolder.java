package com.jay;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/11/22 22:27
 */
public class MonitorInfoHolder {
    private static final ThreadLocal<Map<String, MonitorInfo>> rootMonitorInfos = new ThreadLocal<>();
    private static final ThreadLocal<MonitorInfo> currMonitorInfo = new ThreadLocal<>();

    public static Map<String, MonitorInfo> getRootMonitorInfos(){
        return rootMonitorInfos.get();
    }

    public static MonitorInfo getCurrentMonitorInfo(){
        return currMonitorInfo.get();
    }

    public static void updateCurrentMonitorInfo(MonitorInfo monitorInfo){
        currMonitorInfo.set(monitorInfo);
    }

    public static void init(){
        rootMonitorInfos.set(new HashMap<>());
    }

}
