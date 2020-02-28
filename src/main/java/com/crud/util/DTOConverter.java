package com.crud.util;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.crud.dto.DTO;
import com.crud.entity.Entity;

public class DTOConverter<D extends DTO, E extends Entity> {
    private ModelMapper mapper;
    private Class<D> dtoClass;
    private Class<E> entityClass;

    public DTOConverter(Class<D> dtoClass, Class<E> entityClass) {
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
        mapper = new ModelMapper();
    }

    public E converterDTOParaEntity(D dto) {
        if (dto == null) {
            return null;
        }
        return mapper.map(dto, entityClass);
    }

    public D converterEntityParaDTO(E entity) {
        if (entity == null) {
            return null;
        }
        return mapper.map(entity, dtoClass);
    }

    public E converterDTOParaEntity(Optional<D> dtoOp) {
        return mapper.map(converterDTOParaEntity(dtoOp.get()), entityClass);
    }

    public D converterEntityParaDTO(Optional<E> entity) {
        return mapper.map(converterEntityParaDTO(entity.get()), dtoClass);
    }

    public List<E> converterDTOParaEntity(Collection<D> dtos) {
        return dtos.stream().map(d -> converterDTOParaEntity(d)).collect(Collectors.toList());
    }

    public List<D> converterEntityParaDTO(Collection<E> entity) {
        return entity.stream().map(e -> converterEntityParaDTO(e)).collect(Collectors.toList());
    }

}
