package com.microsoft.bot.builder;

/**
 * Tuple class containing an HTTP Status Code and a JSON Serializable
 * object. The HTTP Status code is, in the invoke activity scenario, what will
 * be set in the resulting POST. The Body of the resulting POST will be
 * the JSON Serialized content from the Body property.
 */
public class InvokeResponse {
    /**
     * The POST that is generated in response to the incoming Invoke Activity
     * will have the HTTP Status code specified by this field.
     */
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int withStatus) {
        this.status = withStatus;
    }

    /**
     * The POST that is generated in response to the incoming Invoke Activity
     * will have a body generated by JSON serializing the object in the Body field.
     */
    private Object body;

    public Object getBody() {
        return body;
    }

    public void setBody(Object withBody) {
        body = withBody;
    }
}