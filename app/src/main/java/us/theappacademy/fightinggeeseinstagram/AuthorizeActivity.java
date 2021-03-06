package us.theappacademy.fightinggeeseinstagram;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;


import us.theappacademy.oauth.OAuthParameters;
import us.theappacademy.oauth.util.UrlBuilder;
import us.theappacademy.oauth.view.AuthorizeFragment;
import us.theappacademy.oauth.view.OAuthActivity;


public class AuthorizeActivity extends OAuthActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        oauthConnection = new InstagramConnection();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setLayoutView() {
        replaceCurrentFragment(new ProfileFragment(), false);

    }

    @Override
    public void replaceCurrentFragment(Fragment newFragment, boolean addToStack) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.fragmentContainer, newFragment);
                if(addToStack){
                 fragmentTransaction.addToBackStack(null);
                }
        fragmentTransaction.commit();
    }

    @Override
    protected Fragment createFragment() {
        AuthorizeFragment authorizeFragment = new AuthorizeFragment();

        OAuthParameters oauthParameters = new OAuthParameters();
        oauthParameters.addParameter("client_id", oauthConnection.getClientID());
        oauthParameters.addParameter("redirect_uri", oauthConnection.getRedirectUrl());
        oauthParameters.addParameter("response_type", "code");
        oauthParameters.addParameter("state", UrlBuilder.generateUniqueState(16));

        oauthConnection.state = oauthParameters.getValueFromParameter("state");

        authorizeFragment.setOAuthParameters(oauthParameters);
        return authorizeFragment;


    }
}
