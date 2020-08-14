package com.ze.challenge.partner.endpoints.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Size;
import static com.ze.challenge.partner.endpoints.rest.resources.RestConstants.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Partner", subTypes = {Object.class})
public class PartnerDto {
    @ApiModelProperty(notes = "id", dataType = "String", example = "1", position = 1)
    private String id;
    @Size(max = 255, message = NAME_IS_TOO_BIG)
    @ApiModelProperty(notes = "tradingName", dataType = "String", example = "1", position = 2)
    private String tradingName;
    @Size(max = 255, message = NAME_IS_TOO_BIG)
    @ApiModelProperty(notes = "ownerName", dataType = "String", example = "1", position = 3)
    private String ownerName;
    @ApiModelProperty(notes = "document", dataType = "String", example = "1", position = 4)
    private String document;

    @ApiModelProperty(notes = "coverageArea", dataType = "String", example = "1", position = 5)
    private CoverageAreaDto coverageArea;

    @ApiModelProperty(notes = "address", dataType = "String", example = "1", position = 6)
    private AddressDto address;

}
