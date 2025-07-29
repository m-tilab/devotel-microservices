package com.devotel.profile.soap.stub;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {}

    public GetUserByIdRequest createGetUserByIdRequest() {
        return new GetUserByIdRequest();
    }

    public GetUserByIdResponse createGetUserByIdResponse() {
        return new GetUserByIdResponse();
    }
}
