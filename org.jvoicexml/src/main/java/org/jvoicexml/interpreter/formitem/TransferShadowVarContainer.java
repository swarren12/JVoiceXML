/*
 * File:    $HeadURL$
 * Version: $LastChangedRevision$
 * Date:    $Date $
 * Author:  $LastChangedBy$
 *
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2005-2006 JVoiceXML group - http://jvoicexml.sourceforge.net
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Library General Public
 *  License as published by the Free Software Foundation; either
 *  version 2 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Library General Public License for more details.
 *
 *  You should have received a copy of the GNU Library General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package org.jvoicexml.interpreter.formitem;

/**
 * Component that provides a container for the shadowed variables of a transfer.
 *
 * @author Dirk Schnelle-Walka
 * @version $Revision$
 * @since 0.7
 */
public final class TransferShadowVarContainer {

    /** The duration of a call transfer in seconds. */
    private long duration;

    /**
     * The input mode of the terminating command (DTMF or voice) or undefined if
     * the transfer was not terminated by a grammar match.
     */
    private String inputmode;

    /**
     * The utterance text used if transfer was terminated by speech recognition
     * input or the DTMF result if the transfer was terminated by DTMF input.
     */
    private String utterance;

    /**
     * Constructs a new object.
     */
    public TransferShadowVarContainer() {
    }

    /**
     * Gets the duration.
     * 
     * @return the duration
     */
    public long getDuration() {
        return duration;
    }

    /**
     * Sets the duration.
     * 
     * @param secs
     *            the new duration
     */
    public void setDuration(final long secs) {
        duration = secs;
    }

    /**
     * Gets the current inputmode.
     * 
     * @return the current inputmode
     */
    public String getInputmode() {
        return inputmode;
    }

    /**
     * Sets the current inputmode.
     * 
     * @param mode
     *            the input mode.
     */
    public void setInputmode(final String mode) {
        inputmode = mode;
    }

    /**
     * Gets the current utterance.
     * 
     * @return the current utterance
     */
    public String getUtterance() {
        return utterance;
    }

    /**
     * Sets the utterance.
     * 
     * @param utter
     *            the new utterance
     */
    public void setUtterance(final String utter) {
        utterance = utter;
    }
}
