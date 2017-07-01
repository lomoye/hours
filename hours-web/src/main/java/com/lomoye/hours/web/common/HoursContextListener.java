package com.lomoye.hours.web.common;




import com.lomoye.common.web.SpringWebContextListener;

import javax.servlet.ServletContextEvent;

public class HoursContextListener extends SpringWebContextListener {


    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
    }
}
