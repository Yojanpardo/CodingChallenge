package com.yojanpardo.controllers;

import java.util.ArrayList;

import com.yojanpardo.interfaces.IndustryQualifier;
import com.yojanpardo.models.Profile;
/**
 * 
 * @author yojan
 * Class to qualify the categories for profiles
 * 
 */
public class Qualifiers implements IndustryQualifier{
	
	/**
	 * qualify the industries for each profile based in a previously load file that contains
	 * a score for each industry
	 * @param ArrayList<Profile> profiles: it's an ArrayList of profiles
	 * @param  ArrayList<String[]> scores: contains industry name and the score for each one 
	 */
	@Override
	public ArrayList<Profile> industryQualifier(ArrayList<Profile> profiles, ArrayList<String[]> scores) {
		ArrayList<Profile> qualifiedProfiles = new ArrayList<Profile>();
		for (Profile profile : profiles) {
			for(String[] score : scores) {
				if(profile.getIndustry().equals(score[0])) {
					profile.setIndustryScore(Integer.parseInt(score[1]));
					qualifiedProfiles.add(profile);
					break;
				}
			}
		}
		return qualifiedProfiles;
	}
}
