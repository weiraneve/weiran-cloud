package com.weiran.graphql.repository;

import com.weiran.graphql.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 车辆Repository
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
