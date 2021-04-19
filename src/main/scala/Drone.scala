
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

import java.util.Properties

class Drone(Id: Int) {

  def doReport(): Unit = {
    val report = Report(Id)
    val rapport = report.getName()
    this.MyProducer.start(rapport)
  }

  def doAlert(alert: String): Unit = {
    this.MyProducer.start2(alert)
  }

  object MyProducer {
    val props = new Properties()

    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)

    def start(rapport: String): Unit = {

      //println("Starting...")
     // println(s"Sending $rapport")
      val message = new ProducerRecord[String, String]("monTopic2", null, rapport)
      producer.send(message)
      //println(message)
      //println("MESSAGE : " + rapport)


    }

    def start2(alert: String): Unit = {

      //println("Starting alert...")
      //println(s"Sending $alert")
      val message = new ProducerRecord[String, String]("Peacemaker1", null, alert)
      producer.send(message)
      //println(message)
      //println("MESSAGE : " + alert)


    }

  }
}
