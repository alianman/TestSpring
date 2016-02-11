package by.st.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by alian on 11.02.2016.
 */
public class MailService {
    private static MailService mailService;
    private WebAddress mainAddress;
    private List<WebAddress> mirrors;
    private String name;
    private Logger logger = LogManager.getLogger(MailService.class);

    private MailService() {
    }

    static public MailService getInstance() {
        if (mailService == null) {
            mailService = new MailService();
        }
        return mailService;
    }

    public WebAddress getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(WebAddress mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WebAddress> getMirrors() {
        return mirrors;
    }

    public void setMirrors(List<WebAddress> mirrors) {
        this.mirrors = mirrors;
    }

    public void init() {
        logger.trace("Mail service connecting...");
    }

    public void destroy() {
        logger.trace("Mail service disonnecting...");
    }
}
