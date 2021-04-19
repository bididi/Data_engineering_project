import org.apache.kafka.clients.consumer.KafkaConsumer

import java.io.{ BufferedWriter, FileWriter}
import java.util.{Collections, Properties, TimerTask}
import scala.collection.JavaConverters._




object MyConsumer {


  def main(args: Array[String]): Unit = {
    val  props = new Properties()

    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("group.id", "monPremierGroupID")
    //props.put("auto.offset.reset", "smallest")

    val consumer = new KafkaConsumer[String, String](props)

    consumer.subscribe(Collections.singletonList("monTopic2"))
    val task = new TimerTask {

      def run()= {
        println("Start receiving...")
        val records=consumer.poll(60000)
        val record = records.asScala
        println("A record has been detected")
        println(record)

        val outputFile = new BufferedWriter(new FileWriter("C:\\Users\\viann\\OneDrive - Efrei\\M1\\S8\\Data-engineering\\Peaceland_pjt\\src\\main\\data1.csv",true))
        val data = record.head.value()
        println(data)
        outputFile.write(data+"\n")
        outputFile.close()

      }


}
    val timer = new java.util.Timer()
    timer.schedule(task, 0, 60)
  }

}
