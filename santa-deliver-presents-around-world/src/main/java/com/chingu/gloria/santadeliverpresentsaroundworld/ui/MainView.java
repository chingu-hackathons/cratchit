package com.chingu.gloria.santadeliverpresentsaroundworld.ui;

import com.chingu.gloria.santadeliverpresentsaroundworld.service.GameService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import java.io.Serializable;


@Route("")
@PWA(name = "Santa Process Dashboard", shortName = "Santa Process",
        description = "A Santa Process dashboard app")
public class MainView extends AppLayout implements Serializable {
    private static final long serialVersionUID = 1L;

    public MainView(GameService gameService) {
        gameService.getHouseholds(10);
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Santa's deliver Monitoring");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tab Dashboard = new Tab(
                VaadinIcon.DASHBOARD.create(),
                new Span("Dashboard")
        );
        Tab Game = new Tab(
                VaadinIcon.GAMEPAD.create(),
                new Span("Game")
        );

        Tabs tabs = new Tabs(Game, Dashboard);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);

        addToNavbar(tabs);
        addToNavbar(toggle, title);

    }

}
