package org.wlcn.w5.admin.infrastructure.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.client.reactive.ReactorResourceFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.util.function.Function;


@Configuration
public class WebClientConfiguration {

    @Bean
    public ReactorResourceFactory resourceFactory() {
        final var factory = new ReactorResourceFactory();
        factory.setUseGlobalResources(false);
        factory.setConnectionProvider(ConnectionProvider.create("w5-webclient"));
        return factory;
    }

    @Bean
    public WebClient webClient() {

        final Function<HttpClient, HttpClient> mapper = client -> {

            client
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10)
                    .doOnConnected(conn -> conn
                            .addHandlerLast(new ReadTimeoutHandler(30))
                            .addHandlerLast(new WriteTimeoutHandler(30))
                    );
            return client;
        };

        final var connector =
                new ReactorClientHttpConnector(resourceFactory(), mapper);

        return WebClient.builder()
                .clientConnector(connector)
                .build();
    }
}
