package com.github.hotire.webservice.feign.client;

import java.io.IOException;

import feign.Client;
import feign.Request;
import feign.Request.Options;
import feign.Response;

/**
 * @see Client
 * @see Client.Default
 */
public class ClientCore implements Client {
    @Override
    public Response execute(Request request, Options options) throws IOException {
        return null;
    }
}
