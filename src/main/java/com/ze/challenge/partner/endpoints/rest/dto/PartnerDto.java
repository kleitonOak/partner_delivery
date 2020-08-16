package com.ze.challenge.partner.endpoints.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ze.challenge.partner.endpoints.rest.resources.RestConstants.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PartnerDto {
    private String id;

    @Size(max = 255, message = NAME_IS_TOO_BIG)
    @NotNull
    private String tradingName;

    @Size(max = 255, message = OWNER_NAME_IS_TOO_BIG)
    @NotNull
    private String ownerName;

    @NotNull
    @Size(max = 50 , message = DOCUMENT_IS_TOO_BIG)
    private String document;

    @NotNull
    private CoverageAreaDto coverageArea;

    @NotNull
    private AddressDto address;

}
