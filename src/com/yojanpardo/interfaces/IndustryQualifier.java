package com.yojanpardo.interfaces;

import java.util.ArrayList;

import com.yojanpardo.models.Profile;

public interface IndustryQualifier {
	ArrayList<Profile> industryQualifier(ArrayList<Profile> profiles, ArrayList<String[]> scores);
}
