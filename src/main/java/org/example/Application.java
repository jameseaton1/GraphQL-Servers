package org.example;

import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * If you want to leverage Apollo Tracing, as supported by java-graphql, you can just create a bean of type [TracingInstrumentation].
     * In this example we added a conditional property on the bean to enable/disable the Apollo Tracing.
     * Enabled by default, you can turn it off by setting `graphql.tracing.enabled=false` in your application properties.
     *
     * @see [Apollo Tracing](https://github.com/apollographql/apollo-tracing)
     */
    @Bean
    @ConditionalOnProperty (prefix = "graphql.tracing", name = "enabled", matchIfMissing = true)
    public Instrumentation tracingInstrumentation() {
        return new TracingInstrumentation();
    }
}