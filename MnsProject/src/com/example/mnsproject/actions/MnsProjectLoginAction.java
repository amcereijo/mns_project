package com.example.mnsproject.actions;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mnsproject.MnsProjectMainActivity;
import com.example.mnsproject.R;
import com.example.mnsproject.application.MnsApplication;
import com.example.mnsproject.dtos.MnsUserDto;
import com.example.mnsproject.exceptions.MnsLoginException;
import com.example.mnsproject.http.MnsProjectHttp;

/**
 * 
 * @author angelcereijo
 *
 */
public class MnsProjectLoginAction extends AsyncTask<Void, Void, Void> {
	
	private final static String TAG = MnsProjectLoginAction.class.getName();
	
	private Activity activity;
	private boolean logged;
	private MnsUserDto userDto;
	private ProgressDialog loadingDialog;
	
	/**
	 * 
	 */
	public MnsProjectLoginAction(){}
	
	/**
	 * 
	 * @param activity
	 */
	public MnsProjectLoginAction(MnsUserDto userDto){
		this.userDto = userDto;
		this.activity = MnsApplication.getActualActivity();
	}
	
	@Override
	protected void onPreExecute() {
		loadingDialog = ProgressDialog.show(activity, activity.getText(R.string.login_action_title),
				activity.getText(R.string.login_action_text));
		super.onPreExecute();
	}
	
	
	@Override
	protected Void doInBackground(Void... arg0) {
		MnsProjectHttp http  = new MnsProjectHttp();
		try {
			http.login(userDto);
			logged = true;
			MnsApplication.setUserDto(userDto);
		} catch (ClientProtocolException e) {
			Log.e(TAG, e.getMessage());
		} catch (URISyntaxException e) {
			Log.e(TAG, e.getMessage());
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		} catch (MnsLoginException e) {
			Log.e(TAG, e.getMessage());
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		if(logged){
			Intent settings = new Intent(activity, MnsProjectMainActivity.class);
			activity.startActivity(settings);
		}else{
			TextView errorView = (TextView)activity.findViewById(R.id.login_error);
			errorView.setText(R.string.login_error);
			errorView.setVisibility(View.VISIBLE);
		}
		loadingDialog.cancel();
	}

}
