package com.github.hotire.core;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.sleuth.CurrentTraceContext;
import org.springframework.cloud.sleuth.http.HttpServerHandler;
import org.springframework.cloud.sleuth.instrument.web.servlet.TracingFilter;

/**
 * @see TracingFilter
 */
@RequiredArgsConstructor
public class TracingFilterCore {

    final CurrentTraceContext currentTraceContext;

    final HttpServerHandler handler;
}
