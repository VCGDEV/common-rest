package com.vcgdev.common.service;

public class ServiceExceptionMessages {
    
    public static final String NOT_FOUND_MESSAGE = "The object was not found";
    public static final String DATA_INSERT_INTEGRITY_MESSAGE = "Error with data saving object";
    public static final String DATA_UPDATE_INTEGRITY_MESSAGE = "Error with data updating object";
    public static final String INTERNAL_ERROR_MESSAGE = "Unable to complete transaction";
    public static final String CONFLICT_MESSAGE = "Unable to complete due to conflict";

    private ServiceExceptionMessages() {}
}
