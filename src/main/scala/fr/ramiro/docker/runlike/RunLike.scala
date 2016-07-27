package fr.ramiro.docker.runlike

import scala.language.postfixOps
import scala.sys.process._

object RunLike extends App {
  implicit class BooleanWrapper(delegate: Boolean) {
    def toOpt: Option[Unit] = if (delegate) { Some() } else { None }
    def invert: Boolean = !delegate
  }

  args.headOption match {
    case Some(container) =>
      val json = s"docker inspect $container" !!

      DockerInspectParser(json).map { container =>
        val options = Seq("name" -> container.Name.stripPrefix("/")) ++
          container.Config.AttachStdout.invert.toOpt.map { _ => "detach" -> "true" } ++
          container.Config.Tty.toOpt.map { _ => "tty" -> "" }

        println(options)

      }

    case _ =>
      System.err.println("container is missing")
  }
}
