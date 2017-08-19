package com.lomoye.hours.backend;

import com.lomoye.common.exception.ThreadUncaughtExceptionLogHandler;
import com.lomoye.common.web.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lomoye on 2017/8/18.
 * 后台程序入口
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_FILE_NAME = "application-context-backend.xml";


    public static void main(String[] args) {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ThreadUncaughtExceptionLogHandler());

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(CONFIG_FILE_NAME);
            SpringContextHolder.setSpringContext(applicationContext);

        } catch (Throwable e) {
            LOGGER.error("SYSTEM BackendMain error:", e);
        }
    }
}
