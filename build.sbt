name := "MyProject"

version := "0.1"

scalaVersion := "2.12.6"

lazy val root = (project in file(".")).
  settings(
    name := "interactive-classroom-server",
    version := "1.0",
    scalaVersion := "2.12.7",
    libraryDependencies ++= Seq(
      "com.google.firebase" % "firebase-admin" % "6.8.1",
//      "io.grpc" % "grpc-netty" %"1.20.0" excludeAll "io.netty" excludeAll "io.grpc",
//        "org.apache.maven.plugins" % "maven-shade-plugin" % "3.2.1",
      //      "io.netty" % "netty-tcnative-boringssl-static" % "2.0.25.Final" classifier "linux-x86_64",
//      "io.grpc" % "grpc-core" % "1.20.0",
//      "io.grpc" % "grpc-stub" % "1.20.0",
//      "io.grpc" % "grpc-auth" % "1.20.0",
//      "io.grpc" % "grpc-protobuf" % "1.20.0",
        "com.typesafe" % "config" % "1.3.3"))
       .enablePlugins(AssemblyPlugin)