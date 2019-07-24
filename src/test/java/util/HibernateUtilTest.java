package util;

import br.com.imobisoftware.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
* Project Name: ImobiSoftware
* User: Filipe Barbosa
* Date: 23/07/2019
*/
public class HibernateUtilTest {

    @Test
    public void conectar() {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        sessao.close();
        HibernateUtil.getFabricaDeSessoes().close();
    }
}
