package com.ze.challenge.partner.endpoints.rest;

import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.core.usercase.create.CreateUseCase;
import com.ze.challenge.partner.endpoints.rest.converter.Converter;
import com.ze.challenge.partner.endpoints.rest.dto.PartnerDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "Partner")
public class CreatePartner extends Base{
    private CreateUseCase createUseCase;

    @ApiResponses(value = {
            @ApiResponse(code = 200, response = PartnerDto.class, message = ""),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Failure", response = Exception.class)})
    @PostMapping(value = BASE_API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartnerDto> createPartner(@RequestBody PartnerDto payload) {
        Partner entity = createUseCase.create(Converter.dtoToEntity(payload));

        return new ResponseEntity<>(Converter.entityToDto(entity), HttpStatus.CREATED);
    }
}
