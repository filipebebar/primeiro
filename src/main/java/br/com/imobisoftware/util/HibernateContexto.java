package br.com.imobisoftware.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
* Project Name: ImobiSoftware
* User: Filipe Barbosa
* Date: 24/07/2019
*/
public class HibernateContexto implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        HibernateUtil.getFabricaDeSessoes().openSession();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.getFabricaDeSessoes().close();
    }
}
