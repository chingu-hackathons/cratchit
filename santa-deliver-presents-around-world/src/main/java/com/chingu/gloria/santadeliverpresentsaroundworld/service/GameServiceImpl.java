package com.chingu.gloria.santadeliverpresentsaroundworld.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chingu.gloria.santadeliverpresentsaroundworld.Constant;
import com.chingu.gloria.santadeliverpresentsaroundworld.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component("gameService")
public class GameServiceImpl implements GameService {
    @Autowired
    private InfoClient infoClient;

    @Override
    public List<Household> getHouseholds(int quantity) {
        List<Household> households = new ArrayList<>();

        int times = (int) Math.ceil(quantity / 1000);
        while (times >= 0 && quantity > 0) {
            int temp = 1000;
            if (times == 0) {
                temp = quantity;
            }
            Response response = infoClient.personList(temp);
            String status = response.getStatus();
            if (status.equals("OK")) {// access the api successfully
                JSONArray personArray = JSON.parseArray(JSON.toJSONString(response.getData()));
                for (int i = 0; i < personArray.size(); i++) {
                    JSONObject obj = personArray.getJSONObject(i);
                    JSONObject addrobj = obj.getJSONObject("address");
                    Address address = Address.builder()
                            .buildingNumber(addrobj.getString("buildingNumber"))
                            .street(addrobj.getString("street"))
                            .streetName(addrobj.getString("streetName"))
                            .city(addrobj.getString("city"))
                            .zipcode(addrobj.getString("zipcode"))
                            .country(addrobj.getString("country"))
                            .county_code(addrobj.getString("county_code"))
                            .build();
                    Household household = Household.builder()
                            .birthday(obj.getString("birthday"))
                            .name(obj.getString("firstname") + " " + obj.getString("lastname"))
                            .email(obj.getString("email"))
                            .address(address)
                            .build();

                    households.add(household);
                }
            }
            times--;
            quantity -= temp;
        }
        return households;
    }

    @Override
    public List<String> getPresents(int quantity) {
        List<String> presents = new ArrayList<>();

        int times = (int) Math.ceil(quantity / 1000);
        while (times >= 0 && quantity > 0) {
            int temp = 1000;
            if (times == 0) {
                temp = quantity;
            }
            // Give the book as a gift
            Response response = infoClient.bookList(temp);

            String status = response.getStatus();
            if (status.equals("OK")) {// access the api successfully
                JSONArray presentArray = JSON.parseArray(JSON.toJSONString(response.getData()));
                for (int i = 0; i < presentArray.size(); i++) {
                    JSONObject obj = presentArray.getJSONObject(i);
                    presents.add(obj.getString("title"));

                }
            }
            times--;
            quantity -= temp;
        }
        return presents;
    }


    @Override
    public void mainLogin(int quantity) {
        // 1. Initial
        List<Household> households = getHouseholds(quantity);
        List<String> present = getPresents(quantity);
        Santa santa = new Santa();
        santa.setCalorieTarget(5000);

        int time = 8 * 60 * 60;// 8h
        // 2. Delivering presents



    }


    public String getCalorieOfSnack() {
        // 60% of the households leave milk & cookies
        // 40% leave him carrots & tea as snacks
        String[] snacks = {"milk", "cookies", "carrots", "tea"};
        Random random = new Random();
        double rate = (double) random.nextInt(10) / 10;
        if (rate < 0.6) {
            return snacks[random.nextInt(2)];
        } else {
            return snacks[random.nextInt(2) + 2];
        }
    }

    public int visit(int count) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += Constant.SNACKS.get(getCalorieOfSnack());
        }
        return total;
    }


}
