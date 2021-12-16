package com.chingu.gloria.santadeliverpresentsaroundworld.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Household {
    private String name;
    private String email;
    private String birthday;
    private Address address;
    private int offerSnack;
    private String present;
}
