package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.NoteDto;

public interface NoteService {

	boolean computeSave(NoteDto noteDto, String token);

	boolean deleteOneNote(long id, String token);

}
