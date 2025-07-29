package com.devotel.user.soap.endpoint;

import com.devotel.user.model.User;
import com.devotel.user.service.UserService;
import com.devotel.user.soap.stub.GetUserByIdRequest;
import com.devotel.user.soap.stub.GetUserByIdResponse;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class UserSoapEndpoint {

    private static final String NAMESPACE_URI = "http://devotel.com/user-service";
    private final UserService userService;

    public UserSoapEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserById(@RequestPayload GetUserByIdRequest request) {
        User user = userService.getUserById(request.getId());

        GetUserByIdResponse response = new GetUserByIdResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        return response;
    }
}
