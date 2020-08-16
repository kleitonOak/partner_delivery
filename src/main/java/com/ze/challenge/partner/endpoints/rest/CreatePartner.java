package com.ze.challenge.partner.endpoints.rest;

import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.core.exceptions.CoreBusinessException;
import com.ze.challenge.partner.core.exceptions.CoreIntegrationException;
import com.ze.challenge.partner.core.usercase.create.CreateUseCase;
import com.ze.challenge.partner.endpoints.rest.converter.Converter;
import com.ze.challenge.partner.endpoints.rest.dto.PartnerDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Validated
@AllArgsConstructor
public class CreatePartner extends Base{
    private CreateUseCase createUseCase;

    @PostMapping(value = BASE_API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartnerDto> createPartner(@RequestBody PartnerDto payload) throws CoreIntegrationException, CoreBusinessException {
        Partner entity = createUseCase.create(Converter.dtoToEntity(payload));
        return new ResponseEntity<>(Converter.entityToDto(entity), HttpStatus.CREATED);
    }
}
