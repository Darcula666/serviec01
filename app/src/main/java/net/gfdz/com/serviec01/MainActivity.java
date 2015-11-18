package net.gfdz.com.serviec01;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    private Button mStartService;
    private Button mStopService;
    private Button mBingService;
    private Button mUnBingService;
   Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myIntent=new Intent(MainActivity.this,MyService.class);
        mStartService= (Button) findViewById(R.id.btnStartService);
        mStartService.setOnClickListener(this);
        mStopService= (Button) findViewById(R.id.btnStopService);
        mStopService.setOnClickListener(this);
        mBingService= (Button) findViewById(R.id.btnBindService);
        mBingService.setOnClickListener(this);
        mUnBingService= (Button) findViewById(R.id.btnUnBingService);
        mUnBingService.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(View v) {
        if (v.getId()==mStartService.getId()){
           startService(myIntent);
        }else if (v.getId()==mStopService.getId()){
            stopService(myIntent);
        }else if (v.getId()==mBingService.getId()){



        }else if (v.getId()==mUnBingService.getId()){



        }
        switch (v.getId()){
            case R.id.btnStartService:
                startService(myIntent);
                break;
            case R.id.btnStopService:
                startService(myIntent);
                break;
            case R.id.btnBindService:
                bindService(myIntent,this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnBingService:
                unbindService(this);
                break;


        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        //服务绑定成功后执行
        System.out.println("Servic Connected");

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
    // 服务所在进程被杀死后执行
        System.out.println("Servic UnConnected");
    }
}
