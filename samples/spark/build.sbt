
import AssemblyKeys._

name := "SparkProject"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.2" % "provided"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.5.2" % "provided"

libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.9"

libraryDependencies += "com.datastax.spark" % "spark-cassandra-connector_2.10" % "1.5.0-M2"

assemblySettings

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
    {
        case PathList("netty", "handler", xs @ _*)    => MergeStrategy.first
        case PathList("netty", "buffer", xs @ _*)     => MergeStrategy.first
        case PathList("netty", "common", xs @ _*)     => MergeStrategy.first
        case PathList("netty", "codec", xs @ _*)      => MergeStrategy.first
        case PathList("META-INF", "io.netty.versions.properties") => MergeStrategy.first
        case x => old(x)
        }
    }

        //case PathList("netty", "transport", xs @ _*)  => MergeStrategy.first
