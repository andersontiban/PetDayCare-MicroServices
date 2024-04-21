package com.andersontiban.ownerservice.webclientconfig;

import com.andersontiban.ownerservice.client.PetsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient petWebClient() {
        return WebClient
                .builder()
                .baseUrl("http://PetService")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public PetsClient petsClient() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.create(petWebClient()))
                .build();
        return httpServiceProxyFactory.createClient(PetsClient.class);
    }
}
