package com.bitdubai.fermat_art_api.layer.sub_app_module.community.fan.exceptions;

import com.bitdubai.fermat_art_api.all_definition.exceptions.ARTException;

/**
 * Created by Manuel Perez (darkpriestrelative@gmail.com) on 05/04/16.
 */
public class FanCancellingFailedException extends ARTException {

    /**
     * Represent the default message
     */
    public static final String DEFAULT_MESSAGE = "FAN CANCELLATION FAILED";

    /**
     * Constructor with parameters
     *
     * @param message
     * @param cause
     * @param context
     * @param possibleReason
     */
    public FanCancellingFailedException(
            final String message,
            final Exception cause,
            final String context,
            final String possibleReason) {
        super(message, cause, context, possibleReason);
    }

    /**
     * Constructor with parameters
     *
     * @param cause
     * @param context
     * @param possibleReason
     */
    public FanCancellingFailedException(
            Exception cause,
            String context,
            String possibleReason) {
        super(DEFAULT_MESSAGE , cause, context, possibleReason);
    }

    /**
     * Constructor with parameters
     *
     * @param message
     * @param cause
     */
    public FanCancellingFailedException(
            final String message,
            final Exception cause) {
        this(message, cause, "", "");
    }

    /**
     * Constructor with parameter
     *
     * @param message
     */
    public FanCancellingFailedException(final String message) {
        this(message, null);
    }

    /**
     * Constructor with parameter
     *
     * @param exception
     */
    public FanCancellingFailedException(final Exception exception) {
        this(exception.getMessage());
        setStackTrace(exception.getStackTrace());
    }

    /**
     * Constructor
     */
    public FanCancellingFailedException() {
        this(DEFAULT_MESSAGE);
    }

}
