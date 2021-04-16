import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

import java.util.Properties

class Drone(Id: Int) {

  def doReport():Unit = {
    val report = Report(Id)
    val rapport = report.getName()
    this.MyProducer.start(rapport)
    Thread.sleep(1000)
  }

  /*object MyTopic{
    val topic = "monTopic"
  }
*/
  object MyProducer {
    val props = new Properties()

    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)

    def start(rapport:String): Unit = {

        println("Starting...")
        //val str = scala.util.Random.nextInt(10).toString
        println(s"Sending $rapport")
        val message = new ProducerRecord[String, String]("monTopic", null, rapport)
        producer.send(message)
        println("MESSAGE : " + rapport)


    }

  }
}
