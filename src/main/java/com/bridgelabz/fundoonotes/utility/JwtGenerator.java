package com.bridgelabz.fundoonotes.utility;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.bridgelabz.fundoonotes.dto.TokenDto;

@Component
public class JwtGenerator {

	private static final String SECRET = "112223333";
	
	public String jwtToken(long l) {
		String token = null;
		try {
			token = JWT.create().withClaim("id", l).sign(Algorithm.HMAC512(SECRET));
		} catch (IllegalArgumentException | JWTCreationException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return token;
	}

	/*
	 * method to parse the jwt token into integer
	 * */
	public int parseJWT(String jwt)
			throws JWTVerificationException, IllegalArgumentException, UnsupportedEncodingException {

		Integer userId = 0;
		if (jwt != null) {
			userId = JWT.require(Algorithm.HMAC512(SECRET)).build().verify(jwt).getClaim("id").asInt();
		}
		return userId;
	}
	
	public TokenDto parseJWTNote(String jwt)
			throws JWTVerificationException, IllegalArgumentException, UnsupportedEncodingException {
        TokenDto noteToken = new TokenDto();
		if (jwt != null) {
		noteToken.setNoteId(JWT.require(Algorithm.HMAC512(SECRET)).build().verify(jwt).getClaim("Note_id").asInt());
		noteToken.setUserId(JWT.require(Algorithm.HMAC512(SECRET)).build().verify(jwt).getClaim("id").asInt());
		}
		
	return	noteToken;
	}

}