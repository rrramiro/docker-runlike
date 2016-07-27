package fr.ramiro.docker.runlike.model

case class ContainerHostConfig(
  Binds: Seq[String],
  ContainerIDFile: String,
  LogConfig: HostConfigLogConfig,
  NetworkMode: String,
  //PortBindings: {},
  RestartPolicy: HostConfigRestartPolicy,
  VolumeDriver: String,
  VolumesFrom: Seq[String],
  //CapAdd: null,
  //CapDrop: null,
  //Dns: [],
  //DnsOptions: [],
  //DnsSearch: [],
  //ExtraHosts: null,
  //GroupAdd: null,
  IpcMode: String,
  Links: Seq[String],
  OomScoreAdj: Int,
  PidMode: String,
  Privileged: Boolean,
  PublishAllPorts: Boolean,
  ReadonlyRootfs: Boolean,
  //SecurityOpt: null,
  UTSMode: String,
  ShmSize: Int,
  ConsoleSize: Seq[Int],
  Isolation: String,
  CpuShares: Int,
  CgroupParent: String,
  BlkioWeight: Int,
  //BlkioWeightDevice: null,
  //BlkioDeviceReadBps: null,
  //BlkioDeviceWriteBps: null,
  //BlkioDeviceReadIOps: null,
  //BlkioDeviceWriteIOps: null,
  CpuPeriod: Int,
  CpuQuota: Int,
  CpusetCpus: String,
  CpusetMems: String,
  //Devices: [],
  KernelMemory: Int,
  Memory: Int,
  MemoryReservation: Int,
  MemorySwap: Int,
  MemorySwappiness: Int,
  OomKillDisable: Boolean,
  PidsLimit: Int
//Ulimits: null
)

case class HostConfigRestartPolicy(
  Name: String,
  MaximumRetryCount: Int
)

case class HostConfigLogConfig(
  Type: String
//Config: {}
)