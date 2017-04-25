package org.tanmay.restApi.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.tanmay.restApi.messenger.database.DatabaseClass;
import org.tanmay.restApi.messenger.model.Profile;

public class ProfileService implements ProfileServices {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	@Override
	public List<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		return new ArrayList<Profile>(profiles.values());
	}

	@Override
	public Profile getProfile(String profileName) {
		// TODO Auto-generated method stub
		return profiles.get(profileName);
	}

	@Override
	public Profile addProfile(Profile profile) {
		// TODO Auto-generated method stub
		
		profile.setId(profiles.size() +1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	@Override
	public Profile updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	@Override
	public Profile removeProfile(String profileName) {
		// TODO Auto-generated method stub
		profiles.remove(profileName);
		return null;
	}
	
	

}
