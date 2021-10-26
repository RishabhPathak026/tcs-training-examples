package com.tcs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.dao.ContactRepository;
import com.tcs.dao.ProfileRepository;
import com.tcs.entities.Contact;
import com.tcs.entities.Profile;
import com.tcs.exceptions.ProfileNotFoundException;
@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileDao;
	@Autowired
	private ContactRepository contactDao;

	@Override
	@Transactional
	public Profile save(Profile profile) {
		return profileDao.save(profile);
	}

	@Override
	public List<Contact> getContacts(int profileId) throws ProfileNotFoundException  {
		Profile profile = getProfile(profileId);
			return profile.getContactsList();
	}

	@Override
	public List<Profile> getProfiles(){
		
		return profileDao.findAll();
	}

	@Override
	@Transactional
	public void deleteContact(int contactId, int profileId)throws ProfileNotFoundException {
		contactDao.deleteContact(contactId, profileId);
	}

	@Override
	public Profile getProfile(int profileId)throws ProfileNotFoundException {
		Profile profile = profileDao.findById(profileId).orElse(null);
		if(profile != null) 
			return profile;
		else 
			throw new ProfileNotFoundException("Profile with id "+profileId+ "Not found");
	}

	@Override
	@Transactional
	public Contact addContact(int profileId, Contact contact)throws ProfileNotFoundException {
		contact.setProfileId(profileId);
		return contactDao.save(contact);
		
	}
}
