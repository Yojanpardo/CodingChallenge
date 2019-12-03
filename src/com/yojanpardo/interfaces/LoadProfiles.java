package com.yojanpardo.interfaces;
import java.util.ArrayList;

import com.yojanpardo.models.Profile;

public interface LoadProfiles {
	ArrayList<Profile> loadProfiles(String profilesFile);
}
