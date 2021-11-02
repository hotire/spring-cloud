package com.github.hotire.webservice.feign.retryer;

import feign.RetryableException;
import feign.Retryer;

/**
 * @see Retryer.Default
 */
public class CustomRetryer implements Retryer {
    @Override
    public void continueOrPropagate(RetryableException e) {

    }

    @Override
    public Retryer clone() {
        return this;
    }
}
