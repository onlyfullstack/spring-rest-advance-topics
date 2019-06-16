package com.onlyfullstack.springprofiles.model;

public class FinalResponse {

	private String configMessage;
	private MailSettings mailSettings;

	public FinalResponse(String configMessage, MailSettings mailSettings) {
		this.configMessage = configMessage;
		this.mailSettings = mailSettings;
	}

	public String getConfigMessage() {
		return configMessage;
	}

	public void setConfigMessage(String configMessage) {
		this.configMessage = configMessage;
	}

	public MailSettings getMailSettings() {
		return mailSettings;
	}

	public void setMailSettings(MailSettings mailSettings) {
		this.mailSettings = mailSettings;
	}
}
