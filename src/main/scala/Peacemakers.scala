import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util.{Collections, Properties, TimerTask}
import scala.collection.JavaConverters._


object Peacemakers {


  def main(args: Array[String]): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("group.id", "monPremierGroupID")


    val consumer = new KafkaConsumer[String, String](props)

    consumer.subscribe(Collections.singletonList("Peacemaker1"))
    val task = new TimerTask {

      def run() = {
        //println("Start receiving...")
        val records = consumer.poll(60000)
        val record = records.asScala
        //println("A record has been detected")
        //println(record)
      }


    }
    val timer = new java.util.Timer()
    timer.schedule(task, 0, 60)
  }
}
