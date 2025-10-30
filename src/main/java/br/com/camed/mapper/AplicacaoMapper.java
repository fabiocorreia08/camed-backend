package br.com.camed.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.camed.dto.AplicacaoDTO;
import br.com.camed.entity.Aplicacao;


@Mapper(componentModel = "spring")
public interface AplicacaoMapper {

    @Mappings({
        @Mapping(source = "cliente.id", target = "clienteId"),
        @Mapping(source = "medicamento.id", target = "medicamentoId"),
        @Mapping(source = "quantidadeDisponivelAposAplicacao", target = "quantidadeDisponivelAposAplicacao")
    })
    AplicacaoDTO toDTO(Aplicacao entity);

    @Mappings({
        @Mapping(target = "cliente.id", source = "clienteId"),
        @Mapping(target = "medicamento.id", source = "medicamentoId"),
        @Mapping(target = "quantidadeDisponivelAposAplicacao", source = "quantidadeDisponivelAposAplicacao")
    })
    Aplicacao toEntity(AplicacaoDTO dto);
}