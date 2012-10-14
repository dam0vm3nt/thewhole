package org.dam0vm3nt.client.auth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AuthenticatorService extends Service {

	@Override
	public IBinder onBind(Intent pIntent) {
		DaM0vm3ntAuthenticator lAuth = new DaM0vm3ntAuthenticator(this);
		return lAuth.getIBinder();
	}

}
