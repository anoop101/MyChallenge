package com.centurylink.challenge.util;

/**
 * @author Anoop
 * CenturyLinkChallengeException
 * custom exception class for this challenge
 */
public class CenturyLinkChallengeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CenturyLinkChallengeException() {
		super("CenturyLinkChallengeException occured.");
	}

	public CenturyLinkChallengeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CenturyLinkChallengeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CenturyLinkChallengeException(String message) {
		super(message);
	}

	public CenturyLinkChallengeException(Throwable cause) {
		super(cause);
	}
	
}
