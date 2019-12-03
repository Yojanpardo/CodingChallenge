package com.yojanpardo.controllers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.yojanpardo.interfaces.LoadProfiles;
import com.yojanpardo.models.Profile;
/**
 * 
 * @author yojan
 * class that helps to get the data to be used in the project
 */
public class GetData implements LoadProfiles{
	/**
	 * Method to load profiles, uses:
	 * @param String profilesFile, it's the file relative path that
	 * contains the profiles information 
	 */
	@Override
	public ArrayList<Profile> loadProfiles(String profilesFile){
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		File file = new File(profilesFile);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String dirtyProfile;
			while ((dirtyProfile = br.readLine()) != null ) {
				String[] cleanProfile = dirtyProfile.split("\\|");
				Profile profile = new Profile();
				profile.setPersonId(cleanProfile[0]);
				profile.setName(cleanProfile[1]);
				profile.setLastName(cleanProfile[2]);
				profile.setCurrentRole(cleanProfile[3]);
				profile.setCountry(cleanProfile[4]);
				profile.setIndustry(cleanProfile[5]);
				profile.setNumberOfRecomendations(Integer.parseInt(cleanProfile[6]));
				profile.setNumberOfConnections(Integer.parseInt(cleanProfile[7]));
				profiles.add(profile);
			}
		}catch (Exception ex) {
			System.out.println("Error loading the profiles file: " + ex);
		}finally {
			try {
				br.close();
			}catch(Exception ex){
				System.out.println("Error trying to close the BufferedReader: " + ex);
			}
		}
		return profiles;
	}
}
