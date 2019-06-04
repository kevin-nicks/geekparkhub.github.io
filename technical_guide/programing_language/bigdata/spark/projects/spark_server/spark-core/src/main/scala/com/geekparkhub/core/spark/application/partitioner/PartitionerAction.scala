package com.geekparkhub.core.spark.application.partitioner

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Geek International Park | 极客国际公园
  * GeekParkHub | 极客实验室
  * Website | https://www.geekparkhub.com/
  * Description | Open开放 · Creation创想 | OpenSource开放成就梦想 GeekParkHub共建前所未见
  * HackerParkHub | 黑客公园枢纽
  * Website | https://www.hackerparkhub.org/
  * Description | 以无所畏惧的探索精神 开创未知技术与对技术的崇拜
  * GeekDeveloper : JEEP-711
  *
  * @author system
  * <p>
  * PartitionerAction
  * <p>
  */

object PartitionerAction {

  def main(args: Array[String]): Unit = {
    // 创建SpakConf
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("PartitionerAction")

    // 创建SC
    val sc = new SparkContext(sparkConf)

    // 创建RDD
    val word: RDD[String] = sc.parallelize(Array("abc", "dcd"))

    // 将元素转换为元祖
    val wordAndOne: RDD[(String, Int)] = word.map((_, 1))

    // 自定义分区
    val partitioned: RDD[(String, Int)] = wordAndOne.partitionBy(new CustomerPartitioner(2))

    // 查看分区后分区结果
    val indexAndData: RDD[(Int, (String, Int))] = partitioned.mapPartitionsWithIndex((i,t)=>t.map((i,_)))

    // 打印数据
    indexAndData.collect().foreach(println)

    // 关闭资源
    sc.stop()
  }
}
