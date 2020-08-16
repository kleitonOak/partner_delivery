package com.ze.challenge.partner.endpoints.rest;

import com.ze.challenge.partner.core.entity.Partner;
import com.ze.challenge.partner.core.usercase.search.SearchUseCase;
import com.ze.challenge.partner.endpoints.rest.converter.Converter;
import com.ze.challenge.partner.endpoints.rest.dto.PartnerDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Validated
@AllArgsConstructor
public class SearchPartner extends Base{
    SearchUseCase searchUseCase;

    private static final String API_PATH = BASE_API_PATH + "/{longitude}" + "/{latitude}";

    @GetMapping(value = API_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PartnerDto>> searchPartner(@NotNull @PathVariable Double longitude, @NotNull @PathVariable Double latitude) {
        List<Partner> entityList = searchUseCase.search(longitude, latitude);
        if(CollectionUtils.isEmpty(entityList))
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        List<PartnerDto> dtoList = entityList.parallelStream().map(e->Converter.entityToDto(e)).collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }
}
