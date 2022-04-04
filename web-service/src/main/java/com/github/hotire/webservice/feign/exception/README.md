# Error


## ErrorDecoder

### SynchronousMethodHandler

~~~java
 asyncResponseHandler.handleResponse(resultFuture, metadata.configKey(), response,
        metadata.returnType(),
        elapsedTime);

    try {
      if (!resultFuture.isDone())
        throw new IllegalStateException("Response handling not done");

      return resultFuture.join();
    } catch (CompletionException e) {
      Throwable cause = e.getCause();
      if (cause != null)
        throw cause;
      throw e;
    }
~~~

### AsyncResponseHandler

~~~java
resultFuture.completeExceptionally(errorDecoder.decode(configKey, response));
~~~
