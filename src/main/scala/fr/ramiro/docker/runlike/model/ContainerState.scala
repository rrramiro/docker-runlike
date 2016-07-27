package fr.ramiro.docker.runlike.model

case class ContainerState(
  Status: String,
  Running: Boolean,
  Paused: Boolean,
  Restarting: Boolean,
  OOMKilled: Boolean,
  Dead: Boolean,
  Pid: Int,
  ExitCode: Int,
  Error: String,
  StartedAt: String,
  FinishedAt: String

)
