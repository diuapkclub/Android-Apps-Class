package decisionmakingcontrolandroid.diu.com.admobsampleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private AdView adView;
    private InterstitialAd mInterstitialAd;
    private Button btnShowAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getString(R.string.app_id));
        btnShowAd = findViewById(R.id.btn_show_ad);

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d("AddTesting", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.d("AddTesting", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.d("AddTesting", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.d("AddTesting", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.d("AddTesting", "onAdClosed");
            }
        });

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        btnShowAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("AddTesting", "The interstitial wasn't loaded yet.");
                }
            }
        });

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d("AddTesting", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.d("AddTesting", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.d("AddTesting", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.d("AddTesting", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.d("AddTesting", "onAdClosed");
            }
        });
    }
}
