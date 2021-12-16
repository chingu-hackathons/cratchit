package com.chingu.gloria.santadeliverpresentsaroundworld.service;

import com.alibaba.fastjson.JSON;
import com.chingu.gloria.santadeliverpresentsaroundworld.SantaDeliverPresentsAroundWorldApplication;
import feign.Feign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;


@SpringBootTest(classes = SantaDeliverPresentsAroundWorldApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoTest {

    @Autowired
    GameService gameService;

    @Test
    public void getHouseholds() {
        System.out.println(JSON.toJSONString(gameService.getHouseholds(1000)));
    }

    @Test
    public void getPresents() {
        System.out.println(JSON.toJSONString(gameService.getPresents(1100).size()));
    }
    @Test
    public void mainLogicTest() {

    }

}