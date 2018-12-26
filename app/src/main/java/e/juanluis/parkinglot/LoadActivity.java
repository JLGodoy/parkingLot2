package e.juanluis.parkinglot;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mLoadTv;

    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        final Intent intent = new Intent(this, LoginActivity.class);
        mProgressBar = (ProgressBar) findViewById(R.id.loadBar);
        mLoadTv = (TextView) findViewById(R.id.loadTv);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(20);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });

                }

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        int message = R.string.load;
                        mLoadTv.setText(message);
                        startActivity(intent);

                    }
                });
            }
        }).start();


    }
}
