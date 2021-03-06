/*
 * File:    $HeadURL$
 * Version: $LastChangedRevision$
 * Date:    $Date$
 * Author:  $LastChangedBy$
 *
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2012-2014 JVoiceXML group - http://jvoicexml.sourceforge.net
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
package org.jvoicexml.callmanager.mmi;

/**
 * An error in a received MMI message has been detected.
 * @author Dirk Schnelle-Walka
 * @version $Revision$
 * @since 0.7.6
 */
public class MMIMessageException extends Exception {
    /** The serial version UID. */
    private static final long serialVersionUID = 6402894946841631760L;

    /**
     * Constructs a new object with the given detail message.
     * @param message the detail message.
     */
    public MMIMessageException(final String message) {
        super(message);
    }

    /**
     * Constructs a new object with the given cause.
     * @param cause the cause for this exception.
     */
    public MMIMessageException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new object with the given detail message and cause.
     * @param message the detail message.
     * @param cause the cause for this exception.
     */
    public MMIMessageException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
