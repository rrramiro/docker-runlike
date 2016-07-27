package fr.ramiro.docker.runlike

import org.scalatest.{ FunSuite, Matchers }

import scala.io.Source

class DockerInspectParserSuite extends FunSuite with Matchers {
  test("parse zero file") {
    val json = Source.fromInputStream(this.getClass.getClassLoader.getResourceAsStream("docker0.json")).mkString
    val actual = DockerInspectParser.apply(json)
    actual shouldNot be(null)
  }

  test("parse first file") {
    val json = Source.fromInputStream(this.getClass.getClassLoader.getResourceAsStream("docker1.json")).mkString
    val actual = DockerInspectParser.apply(json)
    actual shouldNot be(null)
  }

  test("parse second file") {
    val json = Source.fromInputStream(this.getClass.getClassLoader.getResourceAsStream("docker2.json")).mkString
    val actual = DockerInspectParser.apply(json)
    actual shouldNot be(null)
  }

  test("parse thirds file") {
    val json = Source.fromInputStream(this.getClass.getClassLoader.getResourceAsStream("docker3.json")).mkString
    val actual = DockerInspectParser.apply(json)
    actual shouldNot be(null)
  }
}
