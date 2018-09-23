package decisionmakingcontrolandroid.diu.com.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListView  extends BaseAdapter{

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_settings, parent, false);
        TextView textView = view.findViewById(R.id.tv_settings_name);
        textView.setText("");
        ImageView imageView = view.findViewById(R.id.iv_settings_icon);
        return view;
    }

}
