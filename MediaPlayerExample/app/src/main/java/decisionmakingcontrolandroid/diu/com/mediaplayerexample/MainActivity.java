package decisionmakingcontrolandroid.diu.com.mediaplayerexample;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView tvStartTime, tvEndTime;
    private ImageView ivPlayPause;
    private SeekBar seekBar;
    private static MediaPlayer mMediaPlayer = null;
    int startTime, endTime;
    private Handler myHandler = new Handler();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStartTime = findViewById(R.id.tv_start_time);
        tvEndTime = findViewById(R.id.tv_end_time);
        ivPlayPause= findViewById(R.id.iv_play_pause);
        seekBar = findViewById(R.id.seek_bar);

        ivPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mMediaPlayer != null && !mMediaPlayer.isPlaying()){
                    ivPlayPause.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
                    mMediaPlayer.start();
                }
                else if(mMediaPlayer == null){
                    mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.my_music);
                    ivPlayPause.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
                    endTime = mMediaPlayer.getDuration();
                    startTime = mMediaPlayer.getCurrentPosition();
                    tvStartTime.setText(startTime);
                    tvEndTime.setText(endTime);
                    mMediaPlayer.start();
                    seekBar.setMax((int)endTime);
                    seekBar.setProgress((int)startTime);
                    myHandler.postDelayed(UpdateSongTime,100);
                }
                else {
                    if(mMediaPlayer.isPlaying()){
                        mMediaPlayer.pause();
                        ivPlayPause.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                    }
                }
            }
        });
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mMediaPlayer.getCurrentPosition();
            tvStartTime.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}
