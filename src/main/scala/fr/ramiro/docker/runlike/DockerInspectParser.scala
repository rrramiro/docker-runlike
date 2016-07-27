package fr.ramiro.docker.runlike

import com.fasterxml.jackson.databind.{ DeserializationFeature, ObjectMapper }
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import fr.ramiro.docker.runlike.model.DockerContainer

object DockerInspectParser {
  val mapper = new ObjectMapper() with ScalaObjectMapper {
    registerModule(DefaultScalaModule)
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
  }

  def apply(json: String): Seq[DockerContainer] = {
    mapper.readValue[Seq[DockerContainer]](json)
  }
}
