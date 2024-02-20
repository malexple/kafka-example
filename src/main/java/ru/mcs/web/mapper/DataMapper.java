package ru.mcs.web.mapper;


import org.mapstruct.Mapper;
import ru.mcs.model.Data;
import ru.mcs.web.dto.DataDto;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;

@Mapper(componentModel = SPRING)
public interface DataMapper extends Mappable<Data, DataDto> {
}
