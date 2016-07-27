package fr.ramiro.docker.runlike.model

/**
 * Created by Ramiro on 27/07/2016.
 */
case class ContainerConfig(
  Hostname: String,
  Domainname: String,
  User: String,
  AttachStdin: Boolean,
  AttachStdout: Boolean,
  AttachStderr: Boolean,
  Tty: Boolean,
  OpenStdin: Boolean,
  StdinOnce: Boolean,
  Env: Seq[String],
  Cmd: Seq[String],
  Image: String,
  //Volumes: null,
  WorkingDir: String,
  //Entrypoint: null,
  //OnBuild: null,
  //Labels: {},
  StopSignal: String
)
