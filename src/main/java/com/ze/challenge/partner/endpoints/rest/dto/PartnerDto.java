package com.ze.challenge.partner.endpoints.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ze.challenge.partner.endpoints.rest.resources.RestConstants.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Partner", subTypes = {Object.class})
public class PartnerDto {
    @ApiModelProperty(notes = "id", dataType = "String", example = "1", position = 1)
    private String id;

    @Size(max = 255, message = NAME_IS_TOO_BIG)
    @NotNull
    @ApiModelProperty(notes = "tradingName", dataType = "String", example = "1", position = 2)
    private String tradingName;

    @Size(max = 255, message = OWNER_NAME_IS_TOO_BIG)
    @NotNull
    @ApiModelProperty(notes = "ownerName", dataType = "String", example = "1", position = 3)
    private String ownerName;

    @NotNull
    @Size(max = 50 , message = DOCUMENT_IS_TOO_BIG)
    @ApiModelProperty(notes = "document", dataType = "String", example = "1432132123891/0001", position = 4)
    private String document;

    @NotNull
    @ApiModelProperty(notes = "coverageArea", dataType = "Object", example = "1", position = 5)
    private CoverageAreaDto coverageArea;

    @NotNull
    @ApiModelProperty(notes = "address", dataType = "Object", example = "1", position = 6)
    private AddressDto address;

}
