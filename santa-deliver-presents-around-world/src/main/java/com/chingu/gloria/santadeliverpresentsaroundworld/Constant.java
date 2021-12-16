package com.chingu.gloria.santadeliverpresentsaroundworld;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    public static final Map<String, Integer> SNACKS = new HashMap<String, Integer>() {
        {
            put("milk", 75);
            put("cookies", 75);
            put("carrots", -50);
            put("tea ", -50);
        }
    };

    public static final int SPEED_OF_BELOW_5000 = 10;
    public static final int SPEED_OF_ABOVE_5000 = 5;

    public static final int BURN = 60;

}
