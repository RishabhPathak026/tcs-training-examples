package com.tcs.service;

import java.util.List;

import com.tcs.entities.Contact;
import com.tcs.entities.Profile;
import com.tcs.exceptions.ProfileNotFoundException;

public interface ProfileService {
	// you can perform all the crud operations
	public Profile save(Profile profile);
	public Profile getProfile(int profileId) throws ProfileNotFoundException;
	public List<Contact> getContacts(int profileId) throws ProfileNotFoundException;
	public List<Profile> getProfiles();
	public void deleteContact(int contactId, int profileId) throws ProfileNotFoundException;
	public Contact addContact(int profileId, Contact contact) throws ProfileNotFoundException;
}
