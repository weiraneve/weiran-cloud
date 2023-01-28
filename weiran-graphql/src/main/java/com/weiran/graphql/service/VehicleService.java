package com.weiran.graphql.service;

import lombok.RequiredArgsConstructor;
import com.weiran.graphql.entity.Vehicle;
import com.weiran.graphql.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    /**
     * 创建车辆
     */
    @Transactional
    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return vehicleRepository.save(vehicle);
    }

    /**
     * 获取车辆
     */
    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles(final int count) {
        return vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    /**
     * 通过id获取车辆
     */
    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final int id) {
        return vehicleRepository.findById(id);
    }
}
