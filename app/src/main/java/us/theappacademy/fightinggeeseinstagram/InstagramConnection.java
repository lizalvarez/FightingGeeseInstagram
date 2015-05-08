package us.theappacademy.fightinggeeseinstagram;

import us.theappacademy.oauth.OAuthApplication;
import us.theappacademy.oauth.OAuthConnection;
import us.theappacademy.oauth.OAuthProvider;

public class InstagramConnection extends OAuthConnection{
    @Override
    protected OAuthProvider createOAuthProvider() {
        return new OAuthProvider("https://api.instagram.com/v1/",
               "https://api.instagram.com/oauth/authorize",
                "https://api.instagram.com/oauth/access_token",
                "https://localhost");

    }

    @Override
    protected OAuthApplication createOAuthApplication() {
      return new OAuthApplication("85ecd11e99b846959da1fe4b113c0bce", "7d89501ebb8945cfa4ae24475ebb9b8d");
    }
}
