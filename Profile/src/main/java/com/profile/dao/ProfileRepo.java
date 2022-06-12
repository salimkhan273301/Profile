package com.profile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.profile.model.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile,Integer> {

}
