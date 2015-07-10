package aea.lhh.com.androidemanteanimtor;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lhh.aea.emanate.view.EmanateView;


public class SampleActivity extends ActionBarActivity {

    private EmanateView mEmanateView;
    private ImageView mIvGift;
    private Button mBtnGift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        mEmanateView = (EmanateView)this.findViewById(R.id.evAnim);
        mIvGift = (ImageView) this.findViewById(R.id.ivGift);
        mBtnGift = (Button)this.findViewById(R.id.btnGift);
        mBtnGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginAnim();
            }
        });
    }

    public void beginAnim(){
        if(mEmanateView != null){
            if(mIvGift != null) {
                int[] location = new int[2];
                mIvGift.getLocationOnScreen(location);
                mEmanateView.setEmanateStartLoc(location[0],location[1]);
            }
            mEmanateView.setDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.default_gift_color,null),
                    mIvGift.getMeasuredWidth(), mIvGift.getMeasuredHeight());
            mEmanateView.onStartEmanate();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
