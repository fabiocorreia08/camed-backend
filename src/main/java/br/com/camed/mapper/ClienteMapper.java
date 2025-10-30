package br.com.camed.mapper;

import org.mapstruct.Mapper;

import br.com.camed.dto.ClienteDTO;
import br.com.camed.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente cliente);
    Cliente toEntity(ClienteDTO dto);
}
