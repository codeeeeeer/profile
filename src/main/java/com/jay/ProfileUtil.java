package com.jay;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/11/22 22:31
 */
@Slf4j
public class ProfileUtil {
    public static void start(String methodName){
        MonitorInfo currentMonitorInfo = MonitorInfoHolder.getCurrentMonitorInfo();
        MonitorInfo monitorInfo;
        if (currentMonitorInfo == null){
            monitorInfo = MonitorInfoHolder.getRootMonitorInfos().get(methodName);
            if (monitorInfo == null){
                monitorInfo = new MonitorInfo(methodName, null);
                MonitorInfoHolder.getRootMonitorInfos().put(methodName, monitorInfo);
            }
        }else{
            Map<String, MonitorInfo> children = currentMonitorInfo.getChildren();
            if (children == null || (monitorInfo = children.get(methodName)) == null){
                monitorInfo = new MonitorInfo(methodName, currentMonitorInfo);
                currentMonitorInfo.addChild(monitorInfo);
            }
        }
        monitorInfo.setLastStartTime(System.nanoTime());
        MonitorInfoHolder.updateCurrentMonitorInfo(monitorInfo);
    }

    public static void finish(String methodName){
        MonitorInfo currentMonitorInfo = MonitorInfoHolder.getCurrentMonitorInfo();
        CommonUtils.assertTrue(currentMonitorInfo != null, "stack monitor is already empty");
        String currentMonitorInfoMethodName = currentMonitorInfo.getMethodName();
        CommonUtils.assertTrue(Objects.equals(methodName, currentMonitorInfoMethodName),
                String.format("the closing method （%s） is not the current method name（%s）", methodName, currentMonitorInfoMethodName));
        currentMonitorInfo.add(System.nanoTime() - currentMonitorInfo.getLastStartTime());
        MonitorInfoHolder.updateCurrentMonitorInfo(currentMonitorInfo.getParent());
    }

    public static void printSta(){
        StringBuilder result = new StringBuilder("\r\n");
        Collection<MonitorInfo> monitorInfos = MonitorInfoHolder.getRootMonitorInfos().values();
        for (MonitorInfo monitorInfo: monitorInfos) {
            result.append(monitorInfo.toString(1));
        }
        log.info(result.toString());
    }

    public static void init(){
        MonitorInfoHolder.init();
    }

}
