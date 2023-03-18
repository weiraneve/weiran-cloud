package com.weiran.graphql.mutation;

import com.weiran.graphql.entity.Vehicle;
import com.weiran.graphql.repository.VehicleRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class VehicleMutation implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    /**
     * 创造车辆
     */
    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return vehicleRepository.save(vehicle);
    }
}
