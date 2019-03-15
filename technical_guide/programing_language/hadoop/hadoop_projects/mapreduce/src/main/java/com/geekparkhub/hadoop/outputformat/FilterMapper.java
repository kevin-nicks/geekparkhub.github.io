package com.geekparkhub.hadoop.outputformat;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

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
 * FilterMapper
 * <p>
 */

public class FilterMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    /**
     * Rewrite the map() method
     * 重写map()方法
     *
     * @param key
     * @param value
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        /**
         * Write data
         * 写出数据
         */
        context.write(value, NullWritable.get());
    }
}
