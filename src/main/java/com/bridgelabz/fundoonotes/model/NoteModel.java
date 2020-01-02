package com.bridgelabz.fundoonotes.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class NoteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	private String contant;
	
	@Column(columnDefinition = "boolean default false")
	private boolean isPinned;
	
	@Column(columnDefinition = "boolean default false")
	private boolean isArchived;
	
	@Column(columnDefinition = "boolean default false")
	private boolean isDeleted;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	public NoteModel(String title, String contant) {
		super();
		this.title = title;
		this.contant = contant;
	}

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "Id")
	private User userNote;
	
	@Column(columnDefinition = "boolean default 'ffffff")
	private String NoteColor;
	
	private Date localReminder;
	
	private String localReminderStatus;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContant() {
		return contant;
	}

	public void setContant(String contant) {
		this.contant = contant;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isPinned() {
		return isPinned;
	}

	public void setPinned(boolean isPinned) {
		this.isPinned = isPinned;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt() {
		this.createdAt = new Date();
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}



	public User getUserNote() {
		return userNote;
	}

	public void setUserNote(User userNote) {
		this.userNote = userNote;
	}

	public String getNoteColor() {
		return NoteColor;
	}

	public void setNoteColor(String noteColor) {
		NoteColor = noteColor;
	}

	public Date getLocalReminder() {
		return localReminder;
	}

	public void setLocalReminder(Date localReminder) {
		this.localReminder = localReminder;
	}

	public String getLocalReminderStatus() {
		return localReminderStatus;
	}

	public void setLocalReminderStatus(String localReminderStatus) {
		this.localReminderStatus = localReminderStatus;
	}
}
