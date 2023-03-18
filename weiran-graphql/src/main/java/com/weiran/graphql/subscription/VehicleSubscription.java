package com.weiran.graphql.subscription;

import com.weiran.graphql.entity.Vehicle;
import com.weiran.graphql.repository.VehicleRepository;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleSubscription implements GraphQLSubscriptionResolver {

    private final VehicleRepository vehicleRepository;

    public Publisher<Optional<Vehicle>> getVehicleUpdate(final int id) {
        return Flux.interval(Duration.ofSeconds(1))
                .publishOn(Schedulers.boundedElastic())
                .map(sequence -> vehicleRepository.findById(id));
    }
}
