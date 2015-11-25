package chat.rocket.app.ui.splash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import chat.rocket.app.R;
import chat.rocket.app.RocketApp;
import chat.rocket.app.ui.base.BaseActivity;
import chat.rocket.app.ui.home.MainActivity;
import chat.rocket.app.ui.login.LoginActivity;


/**
 * Created by julio on 20/11/15.
 */
public class SplashActivity extends BaseActivity {
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean signedInAutomatically = intent.getBooleanExtra(RocketApp.LOGGED_KEY, false);
            Intent intent1 = new Intent(SplashActivity.this, signedInAutomatically ? MainActivity.class : LoginActivity.class);
            startActivity(intent1);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        IntentFilter filter = new IntentFilter();
        filter.addAction(RocketApp.ACTION_CONNECTED);
        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, filter);
        startMeteorConnection();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
    }

    @Override
    public void onConnect(boolean signedInAutomatically) {
        super.onConnect(signedInAutomatically);
    }

    @Override
    public void onException(Exception e) {
        super.onException(e);
        Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        onBackPressed();
    }
}
