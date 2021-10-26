package com.tcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tcs.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

	// you can create a method that deletes the contact based on the profile id and contact id
	// its just to avoid anybody to delete the contact
	@Modifying
	@Query("delete from Contact c where c.contactId=?1 and c.profileId=?2")
	public void deleteContact(int contactId, int profileId);
}
