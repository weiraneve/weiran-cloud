package com.weiran.graphql.query;

import com.weiran.graphql.entity.Vehicle;
import com.weiran.graphql.repository.VehicleRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VehicleQuery implements GraphQLQueryResolver {

    private final VehicleRepository vehicleRepository;

    /**
     * 获得车辆
     */
    public List<Vehicle> getVehicles(final int count) {
        return vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    /**
     * 获得车辆
     */
    public Optional<Vehicle> getVehicle(final int id) {
        return vehicleRepository.findById(id);
    }
}
