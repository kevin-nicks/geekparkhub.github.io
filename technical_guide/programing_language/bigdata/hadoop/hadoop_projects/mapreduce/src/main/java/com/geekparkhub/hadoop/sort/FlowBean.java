package com.geekparkhub.hadoop.sort;


import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Geek International Park | 极客国际公园
 * GeekParkHub | 极客实验室
 * Website | https://www.geekparkhub.com/
 * Description | Open开放 · Creation创想 | OpenSource开放成就梦想 GeekParkHub共建前所未见
 * HackerParkHub | 黑客公园枢纽
 * Website | https://www.hackerparkhub.com/
 * Description | 以无所畏惧的探索精神 开创未知技术与对技术的崇拜
 * GeekDeveloper : JEEP-711
 *
 * @author system
 * <p>
 * FlowBean
 * <p>
 */

public class FlowBean implements WritableComparable<FlowBean> {

    /**
     * Upstream traffic
     * 上行流量
     */
    private long upFlow;

    /**
     * Downstream traffic
     * 下行流量
     */
    private long downFlow;

    /**
     * Total flow
     * 总流量
     */
    private long sumFlow;

    /**
     * When deserializing, you need to reflect the call to the null parameter constructor.
     * 反序列化时,需要反射调用空参构造器
     */
    public FlowBean() {
    }

    /**
     * Parametric constructor
     * 有参构造器
     *
     * @param upFlow
     * @param downFlow
     */
    public FlowBean(long upFlow, long downFlow) {
        super();
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        sumFlow = upFlow + downFlow;
    }

    /**
     * Rewrite the compare To() method
     * 重写compareTo()方法
     *
     * @param bean
     * @return
     */
    @Override
    public int compareTo(FlowBean bean) {
        /**
         * 处理排序核心CODE
         */
        int result;
        if (sumFlow > bean.getSumFlow()) {
            result = -1;
        } else if (sumFlow < bean.getSumFlow()) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }

    /**
     * Rewrite serialization method
     * 重写 序列化方法
     *
     * @param out
     * @throws IOException
     */
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(upFlow);
        out.writeLong(downFlow);
        out.writeLong(sumFlow);
    }

    /**
     * Overwrite deserialization method
     * 重写 反序列化方法
     *
     * @param in
     * @throws IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        upFlow = in.readLong();
        downFlow = in.readLong();
        sumFlow = in.readLong();
    }

    /**
     * Get&Set method
     * Get&Set方法
     *
     * @return
     */
    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(long downFlow) {
        this.downFlow = downFlow;
    }

    public long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(long sumFlow) {
        this.sumFlow = sumFlow;
    }

    @Override
    public String toString() {
        return "\t" + upFlow + "\t" + downFlow + "\t" + sumFlow;
    }
}