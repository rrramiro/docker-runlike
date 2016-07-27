package fr.ramiro


import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

import scala.language.postfixOps
import scala.sys.process._

case class ContainerAddress
(
HostIp: String,
HostPort: String
)

case class ContainerNetworkSettings
(
 Ports: Map[String, Seq[ContainerAddress]]
)
case class ContainerHostConfig
(
  Binds: Seq[String],
  VolumesFrom: Seq[String],
  Links: Seq[String]
)

case class ContainerConfig
(
  Hostname: String,
  AttachStdin: Boolean,
  AttachStdout: Boolean,
  AttachStderr: Boolean,
  Tty: Boolean,
  OpenStdin: Boolean,
  StdinOnce: Boolean,
  Env: Seq[String],
  Cmd: Seq[String],
  Image: String,
  WorkingDir: String
)

case class DockerContainer
(
  Id: String,
  Created: String,
  Name: String,
  Path: String,
  Args: Seq[String],
  HostConfig: ContainerHostConfig,
  Config: ContainerConfig,
  NetworkSettings: ContainerNetworkSettings
)


object RunLike extends App{
  implicit class BooleanWrapper(delegate: Boolean){
    def toOpt: Option[Unit] = if(delegate) { Some() } else { None }
    def invert: Boolean = ! delegate
  }

  args.headOption match {
    case Some(container) =>
      val json = s"docker inspect $container" !!
      val mapper = new ObjectMapper() with ScalaObjectMapper
      mapper.registerModule(DefaultScalaModule)
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)

      mapper.readValue[Seq[DockerContainer]](json).map{ container =>
        val options = Seq("name" -> container.Name.stripPrefix("/")) ++
          container.Config.AttachStdout.invert.toOpt.map{ _ => "detach" -> "true" } ++
          container.Config.Tty.toOpt.map{ _ => "tty" -> "" }

        println(options)

      }



    case _ =>
      System.err.println("container is missing")
  }
}
