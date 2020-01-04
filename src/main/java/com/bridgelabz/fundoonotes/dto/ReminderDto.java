package com.bridgelabz.fundoonotes.dto;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ReminderDto {

	private String localReminderStatus;
	 
	private Date localReminder;

	public String getLocalReminderStatus() {
		return localReminderStatus;
	}

	public void setLocalReminderStatus(String localReminderStatus) {
		this.localReminderStatus = localReminderStatus;
	}

	public Date getLocalReminder() {
		return localReminder;
	}

	public void setLocalReminder(String localReminder) {
		try {
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.localReminder = date.parse(localReminder);
	}catch (Exception e) {
		e.printStackTrace();
		}
	
}
}
