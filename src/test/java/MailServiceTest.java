import by.st.spring.MailService;
import by.st.spring.WebAddress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alian on 11.02.2016.
 */
public class MailServiceTest extends Assert {
    private MailService mailService;

    @Before
    public void setupContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        mailService = (MailService) context.getBean("mailService");
    }

    @Test
    public void testMailService() {
        assertNotNull(mailService);
        assertEquals("MyMailService", mailService.getName());
        assertEquals("http:\\\\127.0.0.1:80", mailService.getMainAddress().toString());

        List<WebAddress> mirrorsList = new ArrayList<WebAddress>();
        mirrorsList.add(new WebAddress("123.23.23.11", 4213, "https"));
        mirrorsList.add(new WebAddress("192.168.1.1", mailService.getMainAddress().getPort() * 2, mailService.getMainAddress().getProtocol() + "s"));

        assertEquals(mirrorsList, mailService.getMirrors());
    }
}
