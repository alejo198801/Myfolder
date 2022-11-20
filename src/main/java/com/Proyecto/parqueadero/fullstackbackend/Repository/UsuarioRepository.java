package com.Proyecto.parqueadero.fullstackbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyecto.parqueadero.fullstackbackend.Model.usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<usuario, Integer> {

}
