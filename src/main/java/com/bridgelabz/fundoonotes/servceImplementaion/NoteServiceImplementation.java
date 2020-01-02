package com.bridgelabz.fundoonotes.servceImplementaion;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.model.NoteModel;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.NoteService;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;

public class NoteServiceImplementation implements NoteService {

	private final Logger LOGGER = LoggerFactory.getLogger(NoteServiceImplementation.class);

	@Autowired
	private JwtGenerator tokenGenerator;

	@Autowired
	private UserRepository userRepository;



	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private NoteRepository noteRepository;

	@Override
	public boolean computeSave(NoteDto noteDto, String token) {

		try {
			long id = tokenGenerator.parseJWT(token);
			LOGGER.info("Id is :" + id + " ,Description :" + noteDto.getNoteContant());
			User user = userRepository.findById(id);
			if (user!=null) {
				NoteModel note = new NoteModel(noteDto.getNoteTitle(), noteDto.getNoteContant());
				note.setUserNote(user);
				note.setCreatedAt();
				noteRepository.save(note);
				return true;
			}
			/*
			 * else { throw new
			 * NoteCreationException("Something went wrong Note is not created"); }
			 */
			return false;

		} catch (JWTVerificationException | IllegalArgumentException | UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteOneNote(long id, String token) {
		// TODO Auto-generated method stub
		return false;
	}

}
