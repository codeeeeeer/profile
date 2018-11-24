package com.jay;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/11/22 22:09
 */
public class MonitorInfo {
    private long totalTime = 0L;
    private long times = 0L;
    private final String methodName;
    private long lastStartTime;
    private Map<String, MonitorInfo> children;
    private MonitorInfo parent;

    public MonitorInfo(String methodName, MonitorInfo parent) {
        this.methodName = methodName;
        this.parent = parent;
    }

    public void add(long timeNanos){
        this.totalTime += timeNanos;
        this.times ++;
    }

    public void addChild(MonitorInfo monitorInfo){
        if (this.children == null){
            this.children = new HashMap<>();
        }
        this.children.put(monitorInfo.getMethodName(), monitorInfo);
    }

    public String getMethodName() {
        return methodName;
    }

    public long getLastStartTime() {
        return lastStartTime;
    }

    public Map<String, MonitorInfo> getChildren() {
        return children;
    }

    public MonitorInfo getParent() {
        return parent;
    }

    public void setLastStartTime(long lastStartTime) {
        this.lastStartTime = lastStartTime;
    }

    public String toString(int level){
        StringBuilder result = new StringBuilder();
        String curr = String.format("%s was called %d times, cost %d ms", methodName, times, totalTime / 1000000L);
        result.append(StringUtils.repeat("\t", level)).append(curr).append("\r\n");
        if (CommonUtils.isEmpty(children)){
            return result.toString();
        }else{
            Iterator<MonitorInfo> monitorInfoIterator = children.values().iterator();
            while (monitorInfoIterator.hasNext()){
                result.append(monitorInfoIterator.next().toString(level + 1));
            }
            return result.toString();
        }
    }
}
