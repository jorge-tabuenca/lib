package com.duolingo.interfaces;

import java.util.List;
import com.duolingo.model.Category;


public interface ICategory {

	public List<Category> getAllCategories(String courseName);
	
}
