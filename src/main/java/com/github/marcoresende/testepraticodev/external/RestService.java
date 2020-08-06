package com.github.marcoresende.testepraticodev.external;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public abstract class RestService {

    protected RestTemplate getRestTemplate(boolean sslCheck) {
        if (sslCheck) {
            return new RestTemplate();
        }

        return getRestTemplateSemSSLCheck();
    }

    private RestTemplate getRestTemplateSemSSLCheck() {
        SSLContext sslContext;
        try {
            sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy())
                    .build();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            throw new RuntimeException("Ocorreu um erro tentando configurar a requisição http.", e);
        }

        CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(sslContext)
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        return new RestTemplate(requestFactory);
    }
}

