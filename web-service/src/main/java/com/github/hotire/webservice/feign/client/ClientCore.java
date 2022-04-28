package com.github.hotire.webservice.feign.client;

import java.io.IOException;
import java.net.HttpURLConnection;

import feign.Client;
import feign.Request;
import feign.Request.Options;
import feign.Response;

/**
 * @see Client
 * @see Client.Default
 */
public class ClientCore implements Client {
    /**
     * @see Client.Default#execute(Request, Options)
     */
    @Override
    public Response execute(Request request, Options options) throws IOException {
        return null;
    }

    /**
     * @see Client.Default#convertAndSend(Request, Options)
     */
    HttpURLConnection convertAndSend(Request request, Options options) throws IOException {
        return null;
    }
}
