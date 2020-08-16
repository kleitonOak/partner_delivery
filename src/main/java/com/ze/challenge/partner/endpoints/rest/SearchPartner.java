package com.ze.challenge.partner.endpoints.rest;

import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.core.usercase.search.SearchUseCase;
import com.ze.challenge.partner.endpoints.rest.converter.Converter;
import com.ze.challenge.partner.endpoints.rest.dto.PartnerDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Validated
@Api(value = "Partner")
public class SearchPartner extends Base{
    SearchUseCase searchUseCase;

    private static final String API_PATH = BASE_API_PATH + "/{latitude}" + "/{longitude}";

    @ApiResponses(value = {
            @ApiResponse(code = 200, response = PartnerDto.class, message = ""),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Failure", response = Exception.class)})
    @GetMapping(value = API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PartnerDto>> searchPartner(@PathVariable Double latitude, @PathVariable Double longitude) {
        List<Partner> entityList = searchUseCase.search(latitude, longitude);
        if(CollectionUtils.isEmpty(entityList))
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        List<PartnerDto> dtoList = entityList.parallelStream().map(e->Converter.entityToDto(e)).collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }
}
