package com.engageya;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import org.junit.Assert;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.slf4j.LoggerFactory;

/**
 * Created by DANIEL on 3/5/2017
 */
public class LogVerifier {
    public Appender getAppender() {
        Appender mockedAppender = Mockito.mock(Appender.class);
        ((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).addAppender(mockedAppender);
        return mockedAppender;
    }

    public void verifyLogMessage(Appender mockedAppender, String expectedMessage) {
        ArgumentCaptor<Appender> argumentCaptor = ArgumentCaptor.forClass(Appender.class);
        Mockito.verify(mockedAppender).doAppend(argumentCaptor.capture());

// assert against argumentCaptor.getAllValues()
        Assert.assertEquals(1, argumentCaptor.getAllValues().size());
        Assert.assertEquals(expectedMessage, ((LoggingEvent) argumentCaptor.getAllValues().get(0)).getMessage());
    }
}
