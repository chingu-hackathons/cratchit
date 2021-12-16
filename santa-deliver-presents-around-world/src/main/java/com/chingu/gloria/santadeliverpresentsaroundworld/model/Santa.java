package com.chingu.gloria.santadeliverpresentsaroundworld.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Santa {
    private int calorieTarget;
    private int totalCaloriesAccumulated;
    private int totalNumOfMilkAndCookies;
    private int totalNumOfTeaAndCarrots;
    private int currentSpeed;
    private int numOfVisit;
    private int numOfRemaining;
}
