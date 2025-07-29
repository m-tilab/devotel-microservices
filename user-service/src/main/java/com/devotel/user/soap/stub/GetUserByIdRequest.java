package com.devotel.user.soap.stub;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetUserByIdRequest", namespace = "http://devotel.com/user-service")
public class GetUserByIdRequest {
    private Long id;

    @XmlElement(namespace = "http://devotel.com/user-service")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
