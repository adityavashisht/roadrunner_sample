package com.scoa.roadrunner.services.email;


import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;


import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service("soapEmail")
public class SoapEmail implements SoapLogEmailSender {

    private static final Logger logger = LoggerFactory.getLogger(SoapEmail.class);

    private final VelocityEngine velocityEngine;
    private final JavaMailSender mailSender;

    @Value("${mail.admin.from}")
    private String fromEmailAddress;

    @Value("${mail.admin.to}")
    private String toEmailAddress;

    @Value("${mail.enabled.soap.log}")
    private boolean enabled;

    /**
     * Constructor
     */
    @Autowired
    public SoapEmail(VelocityEngine velocityEngine,
                                   JavaMailSender mailSender) {
        this.velocityEngine = velocityEngine;
        this.mailSender = mailSender;
    }


    @Override
    @Async
    public void send(final Map<String, Object> hTemplateVariables) {
        if(enabled) {
            final ConcurrentHashMap<String,Object> valueMap = new ConcurrentHashMap<>();
            valueMap.putAll(hTemplateVariables);
            final String subjectHeader = (String) valueMap.get("SUBJECT");
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_NO);
                    message.setTo(toEmailAddress);
                    message.setFrom(fromEmailAddress);
                    message.setSubject(subjectHeader);
                    String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,"soap-logger-email.vm", "UTF-8", valueMap);
                    logger.info("body={}", body);
                    message.setText(body, true);
                }
            };
            mailSender.send(preparator);
        }
    }
}
