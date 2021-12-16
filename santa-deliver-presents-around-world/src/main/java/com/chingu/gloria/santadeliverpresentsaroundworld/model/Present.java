package com.chingu.gloria.santadeliverpresentsaroundworld.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Present {
    private int id;
    private String title;
}
