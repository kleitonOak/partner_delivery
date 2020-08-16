package com.ze.challenge.partner.endpoints.rest.converter;

import com.ze.challenge.partner.core.entity.Address;
import com.ze.challenge.partner.core.entity.CoverageArea;
import com.ze.challenge.partner.core.entity.GeometryType;
import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.endpoints.rest.dto.AddressDto;
import com.ze.challenge.partner.endpoints.rest.dto.CoverageAreaDto;
import com.ze.challenge.partner.endpoints.rest.dto.GeometryTypeDto;
import com.ze.challenge.partner.endpoints.rest.dto.PartnerDto;
import org.springframework.beans.BeanUtils;

public class Converter {
    public static PartnerDto entityToDto(Partner entity){
        PartnerDto dto = new PartnerDto();
        AddressDto addressDto = new AddressDto();
        CoverageAreaDto coverageAreaDto = new CoverageAreaDto();
        dto.setAddress(addressDto);
        dto.setCoverageArea(coverageAreaDto);


        BeanUtils.copyProperties(entity, dto);
        BeanUtils.copyProperties(entity.getAddress(), addressDto);
        BeanUtils.copyProperties(entity.getCoverageArea(), coverageAreaDto);

        addressDto.setType(GeometryTypeDto.valueOf(entity.getAddress().getType().toString()));
        coverageAreaDto.setType(GeometryTypeDto.valueOf(entity.getCoverageArea().getType().toString()));

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
