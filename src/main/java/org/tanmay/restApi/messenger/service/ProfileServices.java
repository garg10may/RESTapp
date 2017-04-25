package org.tanmay.restApi.messenger.service;

import java.util.List;

import org.tanmay.restApi.messenger.model.Profile;

public interface ProfileServices {
	
	public List<Profile> getAllProfiles() ;
	
	public Profile getProfile(String profileName) ;
	
	public Profile addProfile(Profile profile) ;
	
	public Profile updateProfile(Profile profile);
	
	public Profile removeProfile(String profileName);
	
	

}
