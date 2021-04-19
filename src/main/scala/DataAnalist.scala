import org.apache.spark
import org.apache.spark.sql.SparkSession

object DataAnalist {
  def main(args: Array[String]): Unit = {


    val sparkSession: SparkSession = SparkSession.builder.master("local").appName("Scala Spark").getOrCreate()
    sparkSession.sparkContext.setLogLevel("ERROR")

    val df = sparkSession.read
      .format("csv")
      .option("header", "true")
      .load("src/main/data1.csv")

    df.createOrReplaceTempView("data")
    val count = sparkSession.sql("select * from data").count()
    df.show()
    println("Question 1 : ")

    println("Question 2 : Le mot qui est le plus entendue")
    val repetitif = sparkSession.sql("select Word from data group by Word order by ").count()
    //df.groupBy(factorCol: _*).count.agg(max(struct($"count" +: factorCol: _*)).alias("mostFrequent")).show
    println(repetitif)
    println("Question 3 : La personne avec le plus souvent un peacescore en 50")

    println("Question 4 : La position Lat et Long le plus souvent un score enervé")


    sparkSession.stop()
  }

}
