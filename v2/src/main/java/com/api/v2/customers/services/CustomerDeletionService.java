package com.api.v2.customers.services;

import reactor.core.publisher.Mono;

public interface CustomerDeletionService {

    Mono<Void> delete(String ssn);

}
