package com.github.hotire.webservice.feign.feign_target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import feign.InvocationHandlerFactory;
import feign.Target;

/**
 * @see InvocationHandlerFactory.Default
 */
public class CustomInvocationHandlerFactory implements InvocationHandlerFactory {
    @Override
    public InvocationHandler create(Target target, Map<Method, MethodHandler> dispatch) {
        return null;
    }
}
