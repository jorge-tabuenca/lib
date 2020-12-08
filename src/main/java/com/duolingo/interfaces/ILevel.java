package com.duolingo.interfaces;

import java.util.List;

import com.duolingo.model.Level;

public interface ILevel {
	
	public void insertLevel(int tierLevel, String nameLevel, int categoryID);
	
	public List<Level> getAllLevels(int categoryID);

}
