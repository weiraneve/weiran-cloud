package com.weiran.graphql.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import com.weiran.graphql.entity.Vehicle;
import com.weiran.graphql.service.VehicleService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQuery implements GraphQLQueryResolver {

    private final VehicleService vehicleService;

    /**
     * 获得车辆
     */
    public List<Vehicle> getVehicles(final int count) {
        return vehicleService.getAllVehicles(count);
    }

    /**
     * 获得车辆
     */
    public Optional<Vehicle> getVehicle(final int id) {
        return vehicleService.getVehicle(id);
    }
}
