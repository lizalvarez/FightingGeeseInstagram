package us.theappacademy.fightinggeeseinstagram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import us.theappacademy.oauth.view.OAuthFragment;

public class ProfileFragment extends OAuthFragment {
    private TextView profileName;
    private TextView profileUsername;



    @Override
    public void onTaskFinished(String responseString) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);

        profileName = (TextView)fragmentView.findViewById(R.id.profileName);
        profileUsername = (TextView) fragmentView.findViewById(R.id.userName);

        return fragmentView;
    }
}
