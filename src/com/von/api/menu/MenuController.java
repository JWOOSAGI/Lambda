package com.von.api.menu;

import com.von.api.enums.Messenger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private static MenuController instance = new MenuController();

    private MenuServiceImpl service;
    private MenuController() {service = MenuServiceImpl.getInstance();
    }

    public static MenuController getInstance() {
        return instance;
    }
    public Messenger makeMenuTable(){
        return service.makeMenuTable();
    }
    public Messenger removeMenuTable(){
        return service.removeTable();
    }
    public List<?> getMenusByCategory(String category){
        return service.getMenusByCategory(category);
    }


    public Messenger returnMessenger() throws SQLException {
        Messenger m = service.returnMessenger();
        return m;
    }

    public List<?> returnList() throws SQLException {
        List<?> ls = service.returnList();
        return ls;
    }
}
