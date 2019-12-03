import java.util.ArrayList;

import com.yojanpardo.controllers.Files;
import com.yojanpardo.controllers.GetData;
import com.yojanpardo.controllers.Qualifiers;
import com.yojanpardo.controllers.Sorters;
import com.yojanpardo.models.Profile;

public class BairesDevCodingChallenge {
/**
 * 
 * main method that read the peopel.in file
 * assign a score for the industry to each profile
 * sort the profiles and create the people.out file
 *  
 */
	public static void main(String[] args) {
		GetData getData = new GetData();
		Sorters sorters = new Sorters();
		Files files = new Files();
		Qualifiers qualifiers = new Qualifiers();
		ArrayList<String[]> scores = files.readQualifierFile("files/industriesQualified.tsv", "\t");
		ArrayList<Profile> profiles = getData.loadProfiles("files/R&D Challenge - file 2 (people).in");
		profiles = qualifiers.industryQualifier(profiles, scores);
		
		ArrayList<Profile> sortedProfiles = sorters.sortProfiles(profiles);
		String[] profilesIds = new String[100];
				
		for(int i = 0; i < 100; i++) {
			profilesIds[i]=sortedProfiles.get(i).getPersonId();
		}
		
		files.createFile("people.out", profilesIds, "\n");
		
	}

}
