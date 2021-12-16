package com.chingu.gloria.santadeliverpresentsaroundworld.service;

import com.chingu.gloria.santadeliverpresentsaroundworld.model.Household;

import java.util.List;

public interface GameService {
    public List<Household> getHouseholds(int quantity);

    public List<String> getPresents(int quantity);

    public void mainLogin(int num);

}
