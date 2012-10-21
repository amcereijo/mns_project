package com.example.mnsproject;

import com.example.mnsproject.application.MnsApplication;
import com.example.mnsproject.dtos.MnsUserDto;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

/**
 * 
 * @author angelcereijo
 *
 */
public class MnsProjectMainActivity extends Activity {
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mns_project_main);
        fillText();
    }

    private void fillText() {
    	MnsUserDto userDto = MnsApplication.getUserDto();
    	String text = String.format(getText(R.string.loged).toString(), userDto.getSessionId());
		((TextView)findViewById(R.id.main_text)).setText(text);
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_mns_project_main, menu);
        return true;
    }
    
   
}
