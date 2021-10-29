package com.github.hotire.webservice.feign.method;

import feign.InvocationHandlerFactory.MethodHandler;

/**
 * @see feign.SynchronousMethodHandler
 */
public class CustomMethodHandler implements MethodHandler {
    @Override
    public Object invoke(Object[] argv) throws Throwable {
        return null;
    }
}
