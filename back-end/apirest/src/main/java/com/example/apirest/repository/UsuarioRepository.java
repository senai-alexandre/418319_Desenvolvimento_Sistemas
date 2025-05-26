
package com.example.apirest.repository;

import com.example.apirest.dto.UsuarioDTO;
import com.example.apirest.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.apirest.repository.custom.UsuarioRepositoryCustom;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>, UsuarioRepositoryCustom{
    
}