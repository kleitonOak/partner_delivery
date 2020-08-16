package com.ze.challenge.partner.endpoints.rest.converter;

import com.ze.challenge.partner.core.entity.Address;
import com.ze.challenge.partner.core.entity.CoverageArea;
import com.ze.challenge.partner.core.entity.GeometryType;
import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.endpoints.rest.dto.PartnerDto;
import org.springframework.beans.BeanUtils;

public class Converter {
    public static PartnerDto entityToDto(Partner entity){
        PartnerDto dto = new PartnerDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static Partner dtoToEntity(PartnerDto dto){
        Partner entity = new Partner();
        Address address = new Address();
        CoverageArea coverageArea = new CoverageArea();
        entity.setAddress(address);
        entity.setCoverageArea(coverageArea);

        BeanUtils.copyProperties(dto, entity);
        BeanUtils.copyProperties(dto.getAddress(), address);
        BeanUtils.copyProperties(dto.getCoverageArea(), coverageArea);

        address.setType(GeometryType.valueOf(dto.getAddress().getType().toString()));
        coverageArea.setType(GeometryType.valueOf(dto.getCoverageArea().getType().toString()));

        return entity;
    }
}
