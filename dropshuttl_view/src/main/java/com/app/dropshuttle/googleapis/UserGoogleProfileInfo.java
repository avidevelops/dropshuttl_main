package com.app.dropshuttle.googleapis;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.apache.log4j.Logger;

import com.app.dropshuttl.model.UserModel;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

public class UserGoogleProfileInfo {
	final static Logger logger = Logger.getLogger(UserGoogleProfileInfo.class);

	public static String CLIENT_ID = "362427914912-05uomo62q57tac5rcnmc5849cgv313ds.apps.googleusercontent.com";
	private static final HttpTransport transport = new NetHttpTransport();

	private static final JacksonFactory jsonFactory = new JacksonFactory();

	public UserModel getUserGoogleProfileDetails(String idTokenString) throws GeneralSecurityException, IOException {
		UserModel user = null;
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
				.setAudience(Collections.singletonList(CLIENT_ID))
				// Or, if multiple clients access the backend:
				// .setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2,
				// CLIENT_ID_3))
				.build();

		// (Receive idTokenString by HTTPS POST)

		GoogleIdToken idToken = verifier.verify(idTokenString);
		if (idToken != null) {
			Payload payload = idToken.getPayload();

			// Print user identifier
			String userId = payload.getSubject();
			logger.debug("User ID: " + userId);

			// Get profile information from payload
			String email = payload.getEmail();
			boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			String name = (String) payload.get("name");
			String sub = (String) payload.get("sub");
			// String pictureUrl = (String) payload.get("picture");
			// String locale = (String) payload.get("locale");
			// String familyName = (String) payload.get("family_name");
			// String givenName = (String) payload.get("given_name");
			user = new UserModel();
			user.setUname(name);
			user.setUmailId(email);
			user.setUsocialGID(sub);
			user.setIsloggedinsocial("Y");

			logger.debug("user profile " + name);
		} else {
			System.out.println("Invalid ID token.");
		}
		return user;
	}
}
