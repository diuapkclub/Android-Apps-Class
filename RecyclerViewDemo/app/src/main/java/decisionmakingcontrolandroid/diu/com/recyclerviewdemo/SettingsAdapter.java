package decisionmakingcontrolandroid.diu.com.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder> {


    List<SettingsModel> dataList;
    Context context;

    public SettingsAdapter(List<SettingsModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public SettingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_settings, parent, false);
        return new SettingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SettingsViewHolder holder, int position) {
        holder.tvSettingsName.setText(dataList.get(position).getSettingName());
        holder.ivSettingsIcon.setImageDrawable
                (context.getResources().getDrawable(dataList.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class SettingsViewHolder extends RecyclerView.ViewHolder{

        ImageView ivSettingsIcon;
        TextView tvSettingsName;

        public SettingsViewHolder(View itemView) {
            super(itemView);

            ivSettingsIcon = itemView.findViewById(R.id.iv_settings_icon);
            tvSettingsName=itemView.findViewById(R.id.tv_settings_name);

        }
    }
}
