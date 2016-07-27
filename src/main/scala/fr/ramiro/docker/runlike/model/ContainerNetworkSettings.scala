package fr.ramiro.docker.runlike.model

/**
 * Created by Ramiro on 27/07/2016.
 */
case class ContainerNetworkSettings(

  Bridge: String,
  SandboxID: String,
  HairpinMode: Boolean,
  LinkLocalIPv6Address: String,
  LinkLocalIPv6PrefixLen: Int,
  Ports: Map[String, Seq[ContainerAddress]],
  SandboxKey: String,
  //SecondaryIPAddresses: null,
  //SecondaryIPv6Addresses: null,
  EndpointID: String,
  Gateway: String,
  GlobalIPv6Address: String,
  GlobalIPv6PrefixLen: Int,
  IPAddress: String,
  IPPrefixLen: Int,
  IPv6Gateway: String,
  MacAddress: String,
  Networks: Map[String, ContainerNetwork]
)

