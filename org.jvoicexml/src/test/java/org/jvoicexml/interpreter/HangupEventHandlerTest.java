/*
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2024 JVoiceXML group - http://jvoicexml.sourceforge.net
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.jvoicexml.interpreter;

import org.junit.Assert;
import org.junit.Test;
import org.jvoicexml.ImplementationPlatform;
import org.jvoicexml.SystemOutput;
import org.jvoicexml.event.JVoiceXMLEvent;
import org.jvoicexml.event.plain.ConnectionDisconnectHangupEvent;
import org.mockito.Mockito;

/**
 * Test cases for {@link HangupEventHandler}.
 * @since 0.7.9
 */
public class HangupEventHandlerTest {

    /**
     * Tests the method {@link HangupEventHandler#onEvent(JVoiceXMLEvent)}.
     * @throws JVoiceXMLEvent in case of an error
     * @throws ConnectionDisconnectHangupEvent if the user hung up
     */
    @Test
    public void testOnEvent()
            throws ConnectionDisconnectHangupEvent, JVoiceXMLEvent {
        final ImplementationPlatform platform =
                Mockito.mock(ImplementationPlatform.class);
        final SystemOutput output = Mockito.mock(SystemOutput.class);
        Mockito.when(platform.getSystemOutput()).thenReturn(output);
        final VoiceXmlInterpreterContext context =
                Mockito.mock(VoiceXmlInterpreterContext.class);
        Mockito.when(context.getImplementationPlatform()).thenReturn(platform);
        final VoiceXmlInterpreter interpreter =
                new VoiceXmlInterpreter(context);
        final HangupEventHandler handler = new HangupEventHandler(context,
                interpreter);
        Assert.assertFalse(interpreter.isInFinalProcessingState());
        final ConnectionDisconnectHangupEvent event =
                new ConnectionDisconnectHangupEvent();
        handler.onEvent(event);
        Assert.assertTrue(interpreter.isInFinalProcessingState());
        Mockito.verify(output, Mockito.atLeastOnce()).flushBufferedPrompts();
        Mockito.verify(platform, Mockito.atLeastOnce()).setUserHungup();
    }

}
