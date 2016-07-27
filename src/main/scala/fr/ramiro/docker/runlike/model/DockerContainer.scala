package fr.ramiro.docker.runlike.model

case class DockerContainer(

  Id: String,
  Created: String,
  Path: String,
  Args: Seq[String],
  State: ContainerState,
  Image: String,
  ResolvConfPath: String,
  HostnamePath: String,
  HostsPath: String,
  LogPath: String,
  Name: String,
  RestartCount: Int,
  Driver: String,
  MountLabel: String,
  ProcessLabel: String,
  AppArmorProfile: String,
  //ExecIDs: null,
  HostConfig: ContainerHostConfig,
  GraphDriver: ContainerGraphDriver,
  //Mounts: [],
  Config: ContainerConfig,
  NetworkSettings: ContainerNetworkSettings

)
