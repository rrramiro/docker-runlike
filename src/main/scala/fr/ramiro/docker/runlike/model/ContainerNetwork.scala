package fr.ramiro.docker.runlike.model

case class ContainerNetwork(
  //IPAMConfig: null,
  //Links: null,
  //Aliases: null,
  NetworkID: String,
  EndpointID: String,
  Gateway: String,
  IPAddress: String,
  IPPrefixLen: Int,
  IPv6Gateway: String,
  GlobalIPv6Address: String,
  GlobalIPv6PrefixLen: Int,
  MacAddress: String
)
