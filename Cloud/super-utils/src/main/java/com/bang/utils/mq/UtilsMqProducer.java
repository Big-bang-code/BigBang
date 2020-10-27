package com.bang.utils.mq;

import com.bang.common.config.ThreadPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 */
@Component("utilsMq")
public class UtilsMqProducer {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;//也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装

//    @Autowired
//    private ThreadPoolConfig threadPoolConfig;



}
