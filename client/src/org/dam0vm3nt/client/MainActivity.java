package org.dam0vm3nt.client;

import java.io.IOException;

import org.dam0vm3nt.client.auth.DaM0vm3ntAuthenticator;
import org.dam0vm3nt.client.auth.DaM0vm3ntAuthenticatorActivity;

import android.os.Bundle;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button lButton = (Button) findViewById(R.id.testLogin);
        lButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				testLogin();
				
			}
		});
        
        AccountManager lAccountManager = AccountManager.get(this);
		Account[] lAccounts = lAccountManager.getAccountsByType(DaM0vm3ntAuthenticator.TYPE);
        
        if (lAccounts == null || lAccounts.length==0) {
        	lAccountManager.addAccount(DaM0vm3ntAuthenticator.TYPE, null, null, null, this, new AccountManagerCallback<Bundle>() {
				
				public void run(AccountManagerFuture<Bundle> pFuture) {
					try {
						Bundle lResult = pFuture.getResult();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						Log.e("DaMov","Errore",e);
					} 
					Log.i("DaMov", "boh");
					
				}
			}, null);
        } else if (lAccounts.length==1){
        	gotoHomeActivity(lAccounts[1]);
        } else {
        	// Goto Select account activity        	
        }
        
    }

    
    private void gotoHomeActivity(Account pAccount) {
		// TODO Auto-generated method stub
		
	}

	protected void testLogin() {
    	Intent lTestLoginIntent = new Intent(this,DaM0vm3ntAuthenticatorActivity.class);
    	
		startActivity(lTestLoginIntent);
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
