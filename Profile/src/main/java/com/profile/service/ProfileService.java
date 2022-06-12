package com.profile.service;

import com.profile.model.Profile;

public interface ProfileService {

	Object getAllProfile();

	void saveProfile(Profile p);

	Profile getProfileById(int id);

	void deleteProfileById(int id);

}