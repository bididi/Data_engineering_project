import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util.{Collections, Properties, TimerTask}
import scala.collection.JavaConverters._



object MyConsumer {
//  val props = new Properties()
//  props.put("group.id", "monPremierGroupID")
//  props.put("zookeeper.connect", "localhost:2181")
//  props.put("auto.offset.reset", "smallest")
//
//  val config = new ConsumerConfig(props)
//  val connector = Consumer.create(config)

  def main(args: Array[String]): Unit = {
    val task = new TimerTask {

      def run()= {
      val  props = new Properties()
      props.put("bootstrap.servers", "localhost:9092")
//ee
      props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
      props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
      props.put("group.id", "monPremierGroupID")
   // props.put("auto.offset.reset", "smallest")

      val consumer = new KafkaConsumer[String, String](props)

      consumer.subscribe(Collections.singletonList("monTopic"))

      println("Start receiving...")
      val records=consumer.poll(60000)
      //for (record<-records.asScala) {
        val record = records.asScala
        println("A record has been detected")
        println(record)
      }




}
    val timer = new java.util.Timer()
    timer.schedule(task, 0, 60)
  }
}
