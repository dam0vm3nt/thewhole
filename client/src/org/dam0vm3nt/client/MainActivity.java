package org.dam0vm3nt.client;

import org.dam0vm3nt.client.auth.DaM0vm3ntAuthenticatorActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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
