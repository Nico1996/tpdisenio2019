package com.utn.frsf.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manager {
    private final LoginController loginController;
    private final DashboardGerenteController dashboardGerenteController;

    @Autowired
    public Manager(LoginController l, DashboardGerenteController db){
        this.loginController=l;
        this.dashboardGerenteController=db;
    }


}
