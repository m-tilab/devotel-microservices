package com.devotel.profile.soap.client;

import com.devotel.profile.soap.stub.GetUserByIdRequest;
import com.devotel.profile.soap.stub.GetUserByIdResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class UserSoapClient extends WebServiceGatewaySupport {

    public GetUserByIdResponse getUserById(Long userId) {
        GetUserByIdRequest request = new GetUserByIdRequest();
        request.setId(userId);

        return (GetUserByIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }
}
