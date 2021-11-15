// camel-k: language=java
// camel-k: dependency=camel:camel-quarkus-amqp
// camel-k: dependency=camel:camel-quarkus-timer property=period=1000
// camel-k: trait=prometheus.enabled=true trait=3scale.enabled=true trait=tracing.enabled=true
// camel-k: config=configmap:amqp-source-config

/*
 * The above statements provide information required for running the example. This includes
 * the metadata informing the language used by this code and the dependencies used by
 * Camel K to run this example.
 * As for the dependencies, these are:
 * - camel-quarkus-amqp and camel-quarkus-timer, which are from Camel, thus resolved
 * automatically (hence the prefix notation "camel:")
 */

import org.apache.camel.builder.RouteBuilder;

public class AmqpSourceExample extends RouteBuilder {
  @Override
  public void configure() throws Exception {
      /*
       * Explanation, method by method:
       *
       * - from("amqp:{{amqp.destinationType}}:{{amqp.destinationName}}")
       * Consumes data from the amqp destination configured on the configuration
       * file
       *
       * - to("log:info")
       * Logs the generated fake person name and address to the logger using the info level
       *
       */
      from("amqp:{{amqp.destinationType}}:{{amqp.destinationName}}")
        .routeId("amqp-consumer-route")
        .to("log:info");
  }
}
