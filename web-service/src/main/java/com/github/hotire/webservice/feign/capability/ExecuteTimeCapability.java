package com.github.hotire.webservice.feign.capability;

import java.lang.reflect.InvocationHandler;

import org.springframework.util.StopWatch;

import feign.Capability;
import feign.InvocationHandlerFactory;

public class ExecuteTimeCapability implements Capability {

    interface ExecuteTimeAware {
        void setExecuteTime(Long executeMs);
    }

    @Override
    public InvocationHandlerFactory enrich(InvocationHandlerFactory invocationHandlerFactory) {
        return (target, dispatch) -> (proxy, method, args) -> {
            final StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            final InvocationHandler delegate = invocationHandlerFactory.create(target, dispatch);
            try {
                final Object result = delegate.invoke(proxy, method, args);
                if (result instanceof ExecuteTimeAware) {
                    stopWatch.stop();
                    ((ExecuteTimeAware) result).setExecuteTime(stopWatch.getLastTaskTimeMillis());
                }
                return result;
            } catch (Exception e) {
                if (e instanceof ExecuteTimeAware) {
                    stopWatch.stop();
                    ((ExecuteTimeAware) e).setExecuteTime(stopWatch.getLastTaskTimeMillis());
                }
                throw e;
            }
        };
    }
}
