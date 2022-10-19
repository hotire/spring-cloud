package com.github.hotire.config;

import brave.Tracer;
import brave.Tracing;
import brave.TracingCustomizer;
import brave.handler.SpanHandler;
import brave.propagation.CurrentTraceContext;
import brave.propagation.Propagation;
import brave.propagation.Propagation.Factory;
import brave.sampler.Sampler;
import java.util.List;
import org.springframework.cloud.sleuth.autoconfig.brave.BraveAutoConfiguration;
import org.springframework.cloud.sleuth.autoconfig.brave.SleuthProperties;
import org.springframework.cloud.sleuth.brave.LocalServiceName;
import org.springframework.lang.Nullable;

/**
 * @see BraveAutoConfiguration;
 */
public class BraveAutoConfigurationCore {

    /**
     * @see BraveAutoConfiguration#tracer(Tracing)
     */
    Tracer tracer(Tracing tracing) {
        return tracing.tracer();
    }

    /**
     * @see BraveAutoConfiguration#tracing(String, Factory, CurrentTraceContext, Sampler, SleuthProperties, List, List)
     */
    Tracing tracing(@LocalServiceName String serviceName, Propagation.Factory factory,
        CurrentTraceContext currentTraceContext, Sampler sampler, SleuthProperties sleuthProperties,
        @Nullable List<SpanHandler> spanHandlers, @Nullable List<TracingCustomizer> tracingCustomizers) {
        return Tracing.newBuilder().build();
    }
}
