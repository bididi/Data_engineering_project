import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

import java.util.Properties

object MyTopic{
  val topic = "monTopic"
}

object MyProducer {
  val props = new Properties()


  props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)

  def main(args: Array[String]): Unit = {

    for (i <- 1 to 3) {
      println("Starting...")
      val str = scala.util.Random.nextInt(10).toString
      println(s"Sending $str")
      val message = new ProducerRecord[String, String](MyTopic.topic, null, str)
      producer.send(message)
      println("MESSAGE : " + str)
      Thread.sleep(5000)
    }
  }

}

