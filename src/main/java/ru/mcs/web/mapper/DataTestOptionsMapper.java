package ru.mcs.web.mapper;


import org.mapstruct.Mapper;
import ru.mcs.model.test.DataTestOptions;
import ru.mcs.web.dto.DataTestOptionsDto;

import static org.mapstruct.ap.internal.gem.MappingConstantsGem.ComponentModelGem.SPRING;

@Mapper(componentModel = SPRING)
public interface DataTestOptionsMapper extends
        Mappable<DataTestOptions, DataTestOptionsDto> {
}
