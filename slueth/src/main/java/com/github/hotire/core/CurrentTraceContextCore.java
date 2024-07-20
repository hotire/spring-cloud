package com.github.hotire.core;

import brave.internal.Nullable;
import brave.propagation.CurrentTraceContext.Scope;
import brave.propagation.TraceContext;
import org.springframework.cloud.sleuth.CurrentTraceContext;
import org.springframework.cloud.sleuth.brave.bridge.BraveCurrentTraceContext;

/**
 * @see CurrentTraceContext
 * @see BraveCurrentTraceContext
 * @see brave.propagation.CurrentTraceContext
 * @see brave.propagation.ThreadLocalCurrentTraceContext
 */
public class CurrentTraceContextCore {

    /**
     * @see brave.propagation.CurrentTraceContext#decorateScope(TraceContext, Scope)
     * @see brave.propagation.ThreadLocalCurrentTraceContext#decorateScope(TraceContext, Scope)
     * @param context
     * @param scope
     * @return
     */
    protected Scope decorateScope(@Nullable TraceContext context, Scope scope) {
        return scope;
    }
}
