package com.chanhmn.backendforum.core.transformer;

import java.util.List;

public interface BaseMapper<Entity,DTO> {

    Entity dtoToEntity(DTO dto);

    DTO entityToDTO(Entity entity);

    List<Entity> dtoListToEntityList(List<DTO> dtoList);

    List<DTO> entityListToDTOList(List<Entity> entityList);
}
