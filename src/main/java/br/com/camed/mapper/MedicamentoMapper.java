package br.com.camed.mapper;

import org.mapstruct.Mapper;

import br.com.camed.dto.MedicamentoDTO;
import br.com.camed.entity.Medicamento;

@Mapper(componentModel = "spring")
public interface MedicamentoMapper {
    MedicamentoDTO toDTO(Medicamento medicamento);
    Medicamento toEntity(MedicamentoDTO dto);
}
