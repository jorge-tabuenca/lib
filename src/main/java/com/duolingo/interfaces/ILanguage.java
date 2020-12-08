package com.duolingo.interfaces;

import java.util.List;
import com.duolingo.model.Language;

public interface ILanguage {

	public List<Language> getAllLanguages();
	
	public Language getLanguageByLanguage(short languageId);
	
}
