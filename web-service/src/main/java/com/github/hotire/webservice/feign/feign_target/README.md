# Target

## Proxy 

### Feign

- target
- build

### HardCodedTarget

### ReflectiveFeign

- newInstance

methodToHandler -> ParseHandlersByName

target, methodToHandler -> InvocationHandlerFactory

### ParseHandlersByName

targetToHandlersByName.apply(target)

### SynchronousMethodHandler

### InvocationHandlerFactory

~~~java
 static final class Default implements InvocationHandlerFactory {

    @Override
    public InvocationHandler create(Target target, Map<Method, MethodHandler> dispatch) {
      return new ReflectiveFeign.FeignInvocationHandler(target, dispatch);
    }
  }
~~~

### ReflectiveFeign.FeignInvocationHandler 

