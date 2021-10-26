package com.tcs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.entities.CustomResponse;
import com.tcs.entities.Contact;
import com.tcs.entities.Profile;
import com.tcs.exceptions.ProfileNotFoundException;
import com.tcs.service.ProfileService;

@RestController
@RequestMapping("profile")
public class ProfileRestApi {

	@Autowired
	private ProfileService profileService;

	// storing the profile
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveProfile(@RequestBody Profile profile) {
		return ResponseEntity.status(HttpStatus.CREATED).body(profileService.save(profile));
	}
	// getting all the profiles
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getProfiles() {
		return ResponseEntity.status(HttpStatus.OK).body(profileService.getProfiles());
	}
	// getting the contacts of a particular profile
	@GetMapping(path = "contact/{profileId}")
	public ResponseEntity<Object> getContactFromProfile(@PathVariable("profileId") int profileId) {
		ResponseEntity<Object> response = null;
		try {
			List<Contact> con= profileService.getContacts(profileId);
		response = ResponseEntity.status(HttpStatus.OK).body(con);
		}catch(ProfileNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}	
	// getting a particular profile
	@GetMapping(path = "{profileId}")
	public ResponseEntity<Object> getProfile(@PathVariable("profileId") int profileId) {
		ResponseEntity<Object> response = null;
		try {
			Profile pro= profileService.getProfile(profileId);
		response = ResponseEntity.status(HttpStatus.OK).body(pro);
		}catch(ProfileNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	// getting a particular profile
	@DeleteMapping(path = "{contactId}/{profileId}")
	public ResponseEntity<Object> deleteContactFromProfile(@PathVariable("contactId") int contactId, 
			@PathVariable("profileId") int profileId) {
		ResponseEntity<Object> response = null;
		try {
			profileService.deleteContact(contactId, profileId);
			CustomResponse data = new CustomResponse();
			data.setMsg("contact with an id "+contactId+" deleted");
			response = ResponseEntity.status(HttpStatus.OK).body(data);
		} catch(ProfileNotFoundException e) {
			CustomResponse data = new CustomResponse();
			data.setMsg(e.getMessage());
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		return response;
	}
	
	// storing the customer
		@PostMapping(path="addcont/{profileId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> saveProfile(@PathVariable("profileId") int profileId,@RequestBody Contact contact) {
			ResponseEntity<Object> response = null;
			try {
				Contact con= profileService.addContact(profileId,contact);
			response = ResponseEntity.status(HttpStatus.CREATED).body(con);
			}catch(ProfileNotFoundException e) {
				CustomResponse data = new CustomResponse();
				data.setMsg(e.getMessage());
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
			}
			return response;
		}
		
}
