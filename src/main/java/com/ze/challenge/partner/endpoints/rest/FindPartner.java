package com.ze.challenge.partner.endpoints.rest;

import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.core.usercase.find.FindUseCase;
import com.ze.challenge.partner.endpoints.rest.converter.Converter;
import com.ze.challenge.partner.endpoints.rest.dto.PartnerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@Validated
public class FindPartner extends Base{
    private static final String API_PATH = BASE_API_PATH + "/{id}";

    FindUseCase findUseCase;

    @GetMapping(value = API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartnerDto> getPartner(@PathVariable String id) {
        Partner entity = findUseCase.find(id);
        if(Objects.isNull(entity))
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        return ResponseEntity.ok(Converter.entityToDto(entity));
    }
}
