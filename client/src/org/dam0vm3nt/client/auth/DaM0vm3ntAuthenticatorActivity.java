package org.dam0vm3nt.client.auth;


import org.dam0vm3nt.client.R;

import android.accounts.AccountAuthenticatorActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DaM0vm3ntAuthenticatorActivity extends
		AccountAuthenticatorActivity {

	private EditText mEditText;
	
	private EditText mPassword;
	
	private Button mLoginButton;
	
	private TextView mRegisterView;
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.login);
	
		mEditText = (EditText) findViewById(R.id.username);
		
		mPassword = (EditText) findViewById(R.id.password);
		
		mLoginButton = (Button) findViewById(R.id.loginButton);
		
		mRegisterView = (TextView) findViewById(R.id.registerText);
		
		mLoginButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View pView) {
				doLogin();
				
			}
		});
		
		mRegisterView.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				doRegister();
				
			}
		});
		
	}

	protected void doRegister() {
		// TODO Auto-generated method stub
		
	}

	protected void doLogin() {
		// TODO Auto-generated method stub
		
	}

}
