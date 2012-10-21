package com.example.mnsproject.application;

import com.example.mnsproject.dtos.MnsUserDto;

import android.app.Activity;
import android.app.Application;

/**
 * 
 * @author angelcereijo
 *
 */
public class MnsApplication extends Application {

	
	private static Activity actualActivity;
	private static MnsUserDto userDto;
	
	public static void setActualActivity(Activity actualActivity) {
		MnsApplication.actualActivity = actualActivity;
	}
	public static Activity getActualActivity() {
		return MnsApplication.actualActivity;
	}
	
	public static void setUserDto(MnsUserDto userDto) {
		MnsApplication.userDto = userDto;
	}
	public static MnsUserDto getUserDto() {
		return userDto;
	}
	
	
}
