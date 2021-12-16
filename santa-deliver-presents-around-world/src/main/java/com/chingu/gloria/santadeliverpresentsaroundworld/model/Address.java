package com.chingu.gloria.santadeliverpresentsaroundworld.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String street;
    private String streetName;
    private String buildingNumber;
    private String city;
    private String zipcode;
    private String country;
    private String county_code;
}
