# Spring Cloud

![cloud](doc/img/cloud.jpg)

- Release train Spring Boot compatibility : https://spring.io/projects/spring-cloud

- Spring Cloud 2021.0 Release Notes : https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-2021.0-Release-Notes


### Netflix

https://github.com/hotire/spring-netflix-cloud

### Loadbalancer

https://github.com/hotire/spring-cloud/tree/master/loadbalancer

## Sleuth

- reference : https://cloud.spring.io/spring-cloud-sleuth/reference/html/

### Kafka

- https://github.com/hotire/spring-kafka
- test : https://www.baeldung.com/spring-boot-kafka-testing

spring.sleuth.messaging.kafka.enabled = true

ProducerFactory and ConsumerFactory so that tracing headers get injected into the created Spring Kafka’s Producer and Consumer.

~~~java
	@Configuration(proxyBeanMethods = false)
	@ConditionalOnProperty(value = "spring.sleuth.messaging.kafka.enabled",
			matchIfMissing = true)
	@ConditionalOnClass(ProducerFactory.class)
	protected static class SleuthKafkaConfiguration {
    
	}
~~~

~~~java
    @Pointcut("execution(public * org.springframework.kafka.core.ProducerFactory.createProducer(..))")
	private void anyProducerFactory() {
	} // NOSONAR

	@Pointcut("execution(public * org.springframework.kafka.core.ConsumerFactory.createConsumer(..))")
	private void anyConsumerFactory() {
	} // NOSONAR
~~~
: AOP에 의해 sleuth 설정을 함



### [OpenFeign](https://github.com/hotire/spring-cloud/tree/master/web-service/src/main/java/com/github/hotire/webservice/feign)

- https://www.baeldung.com/spring-cloud-openfeign
