package com.github.hotire.webservice.feign.method;

import feign.InvocationHandlerFactory.MethodHandler;

/**
 * @see feign.SynchronousMethodHandler
 */
public class MethodHandlerCore implements MethodHandler {
    /**
     * @see feign.SynchronousMethodHandler#invoke(Object[])
     */
    @Override
    public Object invoke(Object[] argv) throws Throwable {
        return null;
    }
}
