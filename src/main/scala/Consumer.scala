import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util.{Collections, Properties}
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
    val  props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")

    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("group.id", "monPremierGroupID")
   // props.put("auto.offset.reset", "smallest")

    val consumer = new KafkaConsumer[String, String](props)

    consumer.subscribe(Collections.singletonList(MyTopic.topic))

    while(true){
      println("Start receiving...")
      val records=consumer.poll(5000)
      for (record<-records.asScala){
        println("A record has been detected")
        println(record)
      }
    }
  }


}
