import org.apache.spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.dsl.expressions.StringToAttributeConversionHelper
import org.apache.spark.sql.functions.asc
import org.apache.spark.sql.functions._

import scala.collection.immutable.Nil.groupBy


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

    println("Question 1 : Peacescore moyen par drone ")
    val drone = sparkSession.sql("SELECT Id, ((AVG(Peacescore1)+AVG(Peacescore2)+AVG(Peacescore3))/3) AS score from data GROUP BY Id order by score DESC ").show()

    println("Question 2 : Le mot qui est le plus entendue")
    val repetitif = sparkSession.sql("select Word, count (Word) as value from data group by Word order by value desc").show(1)


    println("Question 3 : La personne avec le plus souvent un peacescore en dessous de 50")
    val peace = sparkSession.sql("Select * from ((Select Name1, count(Peacescore1)as neg1 from data where(Peacescore1<50) GROUP by Name1) as tab1 full join (Select Name2, count(Peacescore2)as neg2 from data where(Peacescore2<50) GROUP by Name2) as tab2 ON tab1.Name1 = tab2.Name2 full join (Select Name3 , count(Peacescore3)as neg3 from data where(Peacescore3<50) GROUP by Name3) as tab3 ON tab2.Name2 = tab3.Name3);").show()

    println("Question 4 : La position Lat et Long avec le score le peascore le plus élevé")
    val geo = sparkSession.sql("SELECT Long, Lat, AVG(Peacescore1)+AVG(Peacescore2)+AVG(Peacescore3) AS score from data GROUP BY Long, Lat order by score DESC ").show(1)
  }

}
