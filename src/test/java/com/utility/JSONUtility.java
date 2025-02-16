package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	
	
	public static Environment readJson(Env en) {
		
		Gson gson = new Gson();
		File jsonFile = new File (System.getProperty("user.dir")+ "//config//config.json");
		FileReader fileReader = null;
		Config config ;
		Environment environment;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		config = gson.fromJson(fileReader, Config.class);
		environment = config.getEnvironments().get("QA");
		return environment;
	}
}
