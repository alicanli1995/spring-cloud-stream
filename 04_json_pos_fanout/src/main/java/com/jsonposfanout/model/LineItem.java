package com.jsonposfanout.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LineItem {
        @JsonProperty("ItemCode")
        private String itemCode;
        @JsonProperty("ItemDescription")
        private String itemDescription;
        @JsonProperty("ItemPrice")
        private Double itemPrice;
        @JsonProperty("ItemQty")
        private Integer itemQty;
        @JsonProperty("TotalValue")
        private Double totalValue;
}
