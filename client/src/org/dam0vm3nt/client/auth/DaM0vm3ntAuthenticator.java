package org.dam0vm3nt.client.auth;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DaM0vm3ntAuthenticator extends
		AbstractAccountAuthenticator {
	
	public final static String TYPE = "org.dam0vm3nt.client.auth.DaM0vm3ntAuthenticator";

	private Context mContext;
	
	public DaM0vm3ntAuthenticator(Context context) {
		super(context);
		this.mContext = context;
	}

	@Override
	public Bundle addAccount(AccountAuthenticatorResponse pResponse, String pAccountType,
			String pAuthTokenType, String[] pRequiredFeatures, Bundle pOptions)
			throws NetworkErrorException {
		Bundle lBundle = new Bundle();
	
		Intent lIntent = new Intent(mContext, DaM0vm3ntAuthenticatorActivity.class);
		lBundle.putParcelable(AccountManager.KEY_INTENT, lIntent);
		lBundle.putParcelable(AccountManager.KEY_ACCOUNT_MANAGER_RESPONSE, pResponse);
		return lBundle;
	}

	@Override
	public Bundle confirmCredentials(AccountAuthenticatorResponse arg0,
			Account arg1, Bundle arg2) throws NetworkErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle editProperties(AccountAuthenticatorResponse arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle getAuthToken(AccountAuthenticatorResponse arg0, Account arg1,
			String arg2, Bundle arg3) throws NetworkErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthTokenLabel(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle hasFeatures(AccountAuthenticatorResponse arg0, Account arg1,
			String[] arg2) throws NetworkErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle updateCredentials(AccountAuthenticatorResponse arg0,
			Account arg1, String arg2, Bundle arg3)
			throws NetworkErrorException {
		// TODO Auto-generated method stub
		return null;
	}

}
