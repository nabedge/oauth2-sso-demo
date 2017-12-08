package com.example;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class OAuth2ClientDetailsService implements ClientDetailsService {

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        // FIXME とりあえず固定値で返す
        OAuthClientDetails cd = new OAuthClientDetails();

        cd.setScope(Arrays.asList("read", "write"));

        cd.setClientId("demo2");
        cd.setClientSecret("demo2");

        //        cd.setRegisteredRedirectUri(client.getRedirectUris());
        cd.setAutoApproveScopes(Collections.singleton("true"));
        cd.setAuthorizedGrantTypes(Collections.singleton("authorization_code"));

        return cd;
    }
}
