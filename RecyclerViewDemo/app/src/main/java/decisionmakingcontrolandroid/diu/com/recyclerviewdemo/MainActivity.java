package decisionmakingcontrolandroid.diu.com.recyclerviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView rvSettingsList;
    SettingsAdapter settingsAdapter;

    List<SettingsModel>dataList;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();
        initViews();
        loadData();
        initFunctionality();
    }

    private void initViews(){
        setContentView(R.layout.activity_main);
        rvSettingsList=findViewById(R.id.rv_settings_list);
    }

    private void initVariables(){
        dataList = new ArrayList<>();
        context=getApplicationContext();
    }

    private void loadData(){
        dataList.add(new SettingsModel("Bluetooth", R.drawable.bluetooth));
        dataList.add(new SettingsModel("Brightness", R.drawable.brightness));
        dataList.add(new SettingsModel("Message", R.drawable.message));
        dataList.add(new SettingsModel("Network", R.drawable.network_strength));
        dataList.add(new SettingsModel("Phone", R.drawable.phone));
        dataList.add(new SettingsModel("WiFi", R.drawable.wifi_strength));
        dataList.add(new SettingsModel("Bluetooth", R.drawable.bluetooth));
        dataList.add(new SettingsModel("Brightness", R.drawable.brightness));
        dataList.add(new SettingsModel("Message", R.drawable.message));
        dataList.add(new SettingsModel("Network", R.drawable.network_strength));
        dataList.add(new SettingsModel("Phone", R.drawable.phone));
        dataList.add(new SettingsModel("WiFi", R.drawable.wifi_strength));
    }

    private void initFunctionality(){
        settingsAdapter = new SettingsAdapter(dataList, context);
        rvSettingsList.setLayoutManager
                (new LinearLayoutManager(context, LinearLayout.VERTICAL, false));
        rvSettingsList.setAdapter(settingsAdapter);
    }
}
