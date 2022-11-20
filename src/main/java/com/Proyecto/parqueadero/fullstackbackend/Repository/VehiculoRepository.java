package com.Proyecto.parqueadero.fullstackbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyecto.parqueadero.fullstackbackend.Model.vehiculo;
@Repository
public interface VehiculoRepository extends JpaRepository<vehiculo, Integer> {

}
