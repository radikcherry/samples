package org.cherry.sample;

import com.amazonaws.services.lambda.runtime.Context;

public class LambdaMethodHandler {

    public TestResource handleRequest(TestResource input, Context context) {
        context.getLogger().log("Input: " + input);
        return new TestResource("Hello World - " + input.getMessage());
    }

}
