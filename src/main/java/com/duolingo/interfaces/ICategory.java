package com.duolingo.interfaces;

import java.util.List;
import com.duolingo.model.Category;


public interface ICategory {

	public List<Category> getAllCategories(int languageID, int courseID);
	
	public void insertCategory(int languageID, int courseID, String name);
	
	public int getCategoryID(int languageID, int courseID, int position);
	
}
