package org.dam0vm3nt.client.auth;


import org.dam0vm3nt.client.R;
import org.dam0vm3nt.client.services.AccountID;
import org.dam0vm3nt.client.services.AuthenticationException;
import org.dam0vm3nt.client.services.DaM0vm3ntService;
import org.dam0vm3nt.client.services.Services;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DaM0vm3ntAuthenticatorActivity extends
		AccountAuthenticatorActivity {

	private EditText mUsername;
	
	private EditText mPassword;
	
	private Button mLoginButton;
	
	private TextView mRegisterView;
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.login);
	
		mUsername = (EditText) findViewById(R.id.username);
		
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
		doIt(true);
	}

	private void doIt(boolean pRegister) {
		try {
			String lUsername = mUsername.getText().toString();
			String lPassword = mPassword.getText().toString();
			DaM0vm3ntService lMainService = Services.$(DaM0vm3ntService.class);
			AccountID lId;
			if (pRegister) {
				lId = lMainService.registerNewAccount(lUsername, lPassword);
			} else {
				lId = lMainService.authenticate(lUsername, lPassword);
			}
			
			registerAccount(lUsername, lPassword, lId);
		
			Bundle lBundle = new Bundle();
			lBundle.putString(AccountManager.KEY_ACCOUNT_NAME, lUsername);
			lBundle.putString(AccountManager.KEY_ACCOUNT_TYPE,DaM0vm3ntAuthenticator.TYPE);
			setAccountAuthenticatorResult(lBundle);
			finish();
			
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void registerAccount(String pUsername,String pPassword, AccountID pId) {
		
		final Account account = new Account(pUsername, DaM0vm3ntAuthenticator.TYPE);
		if (!AccountManager.get(this).addAccountExplicitly(account, null, null)) {
			Log.e("Account", "Cannot add account "+pUsername);
		}
	}

	protected void doLogin() {
		doIt(false);
		
	}

}
