/*
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2021 JVoiceXML group - http://jvoicexml.sourceforge.net
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jvoicexml.ImplementationPlatform;
import org.jvoicexml.SystemOutput;
import org.jvoicexml.event.EventSubscriber;
import org.jvoicexml.event.JVoiceXMLEvent;
import org.jvoicexml.event.error.NoresourceError;
import org.jvoicexml.event.plain.ConnectionDisconnectHangupEvent;

/**
 * Default handler for events of type {@link ConnectionDisconnectHangupEvent}.
 * @author Dirk Schnelle-Walka
 * @since 0.7.9
 */
public class HangupEventHandler implements EventSubscriber {
    /** Logger for this class. */
    private static final Logger LOGGER = LogManager
            .getLogger(HangupEventHandler.class);

    /** The context of the current VoiceXML interpreter. */
    private final VoiceXmlInterpreterContext context;

    /** The used form {@link VoiceXmlInterpreter}. */
    private final VoiceXmlInterpreter interpreter;

    /**
     * Creates a new object.
     * @param ctx the context of the current VoiceXML interpreter
     * @param ip the VoiceXML interpreter to use
     */
    public HangupEventHandler(final VoiceXmlInterpreterContext ctx, 
            final VoiceXmlInterpreter ip) {
        context = ctx;
        interpreter = ip;
    }
    
    /**
     * {@inheritDoc}
     * 
     * Notify the {@link FormInterpretationAlgorithm} to enter the final
     * processing state if not done, yet.
     */
    @Override
    public void onEvent(final JVoiceXMLEvent event) {
        if (interpreter.isInFinalProcessingState()) {
            return;
        }
        LOGGER.info("received hangup event '" + event 
                + "'. Entering final processing state");
        interpreter.setState(InterpreterState.FINALPROCESSING);
        final ImplementationPlatform platform =
                context.getImplementationPlatform();
        try {
            LOGGER.info("flushing buffered prompts");
            final SystemOutput output = platform.getSystemOutput();
            output.flushBufferedPrompts();
            // Mark the user as hung up to avoid any further queuing of prompts
            platform.setUserHungup();
        } catch (ConnectionDisconnectHangupEvent e) {
            // ignore another hangup event
        } catch (NoresourceError e) {
            LOGGER.warn("error while trying to flush prompt buffers", e);
        }
    }

}
