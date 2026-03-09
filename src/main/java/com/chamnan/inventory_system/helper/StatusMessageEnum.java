package com.chamnan.inventory_system.helper;

import lombok.Getter;

@Getter
public enum StatusMessageEnum {
    //	200
    OK(200),
    CREATED(201) ,
    ACCEPTED(202) ,
    NO_CONTENT(204),
    //	300
    MOVED_PERMANENTLY(301) ,
    SEE_OTHER(303),
    NOT_MODIFIED(304) ,
    TEMPORARY_REDIRECT(307),
    //	400
    BAD_REQUEST(400) ,
    UNAUTHORIZED(401) ,
    FORBIDDEN(403),
    NOT_FOUND(404) ,
    METHOD_NOT_ALLOW(405),
    NOT_ACCEPTABLE(406),
    CONFLICT(409) ,
    GONE(410),

    PRECONDITION_FAILED(412),
    UNSUPPORTED_MEDIA_TYPE(415),
    //	500
    INTERNAL_SERVER_ERROR(500) ,
    SERVICE_UNAVAILABLE(503);

    private final int statusCode;

    private StatusMessageEnum(int statusCode){
        this.statusCode = statusCode;
    }

    public static StatusMessageEnum fromText(int statusCode) {
        for (StatusMessageEnum code : values()) {
            if (code.getStatusCode() == statusCode) {
                return code;
            }
        }
        return null;
    }
}
