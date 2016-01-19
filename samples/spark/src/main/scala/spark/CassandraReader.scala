// Spark
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

// Cassandra
import com.datastax.spark.connector._

object CassandraReader {
  def main(args: Array[String]) {
    // Spark settings
    val conf = new SparkConf()
               .setAppName("Cassandra Reader")
               .set("spark.cassandra.connection.host", "localhost")
    val sc = new SparkContext(conf)

    val data = sc.cassandraTable("mykeyspace", "users")
    data.map(row => row.getInt("user_id")).foreach(println)
  }
}
