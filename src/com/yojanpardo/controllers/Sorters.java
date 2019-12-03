package com.yojanpardo.controllers;

import java.util.ArrayList;

import com.yojanpardo.interfaces.BubbleSort;
import com.yojanpardo.models.Profile;
/**
 * 
 * @author yojan
 * Class used to sort the data
 */
public class Sorters implements BubbleSort{
	/**
	 * it's a bubbleSort algorithm with some extra validations that helps to sort the profiles based
	 * in the number of recommendations, industryScore and number of connections.
	 * @param ArrayList<Profile> profiles: it's the profiles list with the score for the industry 
	 */
	@Override
	public ArrayList<Profile> sortProfiles(ArrayList<Profile> profiles) {
		int n = profiles.size();
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) {
				if (profiles.get(j).getNumberOfRecomendations()<profiles.get(j+1).getNumberOfRecomendations()){
					Profile temp = profiles.get(j);
					profiles.set(j, profiles.get(j+1));
					profiles.set(j+1, temp);
				}else if (profiles.get(j).getNumberOfRecomendations()==profiles.get(j+1).getNumberOfRecomendations()){
					if(profiles.get(j).getIndustryScore() < profiles.get(j+1).getIndustryScore()) {
						Profile temp = profiles.get(j);
						profiles.set(j, profiles.get(j+1));
						profiles.set(j+1, temp);
					} else if(profiles.get(j).getIndustryScore() == profiles.get(j+1).getIndustryScore()) {
						if(profiles.get(j).getNumberOfConnections() < profiles.get(j+1).getNumberOfConnections()) {
							Profile temp = profiles.get(j);
							profiles.set(j, profiles.get(j+1));
							profiles.set(j+1, temp);
						}
					}
				}
			}
		}
		return profiles;
	}
}
