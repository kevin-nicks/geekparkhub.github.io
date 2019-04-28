package com.geekparkhub.core.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

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
 * NewProduce
 * <p>
 */

public class NewProduce {
    public static void main(String[] args) {

        /**
         * Configuration information
         * 配置信息
         */
        Properties props = new Properties();

        /**
         * Kafka configuration information
         * Kafka配置信息
         */
        props.put("bootstrap.servers", "systemhub511:9092");

        /**
         * Response level
         * 应答级别
         */
        props.put("acks", "all");

        /**
         * number of retries
         * 重试次数
         */
        props.put("retries", 0);

        /**
         * Cache size
         * 缓存大小
         */
        props.put("batch.size", 16384);

        /**
         * Submission delay
         * 提交延时
         */
        props.put("linger.ms", 1);

        /**
         * Cache mode
         * 缓存方式
         */
        props.put("buffer.memory", 33554432);

        /**
         * K value serialization
         * K值 序列化
         */
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        /**
         * V value serialization
         * V值 序列化
         */
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        /**
         * Instantiate producer object
         * 实例化 生产者对象
         */
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        /**
         * Cycling data
         * 循环发送数据
         */
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>("topic001", String.valueOf(i)));
            System.out.println("Result is = " + producer.toString());
        }

        /**
         * Close resource
         * 关闭资源
         */
        producer.close();

    }
}