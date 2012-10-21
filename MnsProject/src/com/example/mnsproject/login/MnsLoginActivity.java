package com.example.mnsproject.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mnsproject.R;
import com.example.mnsproject.actions.MnsProjectLoginAction;
import com.example.mnsproject.application.MnsApplication;
import com.example.mnsproject.dtos.MnsUserDto;

/**
 * 
 * @author angelcereijo
 *
 */
public class MnsLoginActivity extends Activity {
	
	private MnsUserDto userDto;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mnslogin);
        userDto = new MnsUserDto();
        MnsApplication.setActualActivity(this);
    }

    /**
     * 
     * @param v
     */
    public void login(View v){
    	readUserData();
    	new MnsProjectLoginAction(userDto).execute();
    	
    }
    
    private void readUserData(){
    	String user = ((TextView)findViewById(R.id.login_user)).getText().toString();
    	String password = ((TextView)findViewById(R.id.login_password)).getText().toString();
    	userDto.setUser(user);
    	userDto.setPassword(password);
    }
}
