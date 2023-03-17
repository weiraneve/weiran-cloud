package com.weiran.graphql.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import com.weiran.graphql.entity.Vehicle;
import com.weiran.graphql.service.VehicleService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleMutation implements GraphQLMutationResolver {

    private final VehicleService vehicleService;

    /**
     * 创造车辆
     */
    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        return vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }
}
