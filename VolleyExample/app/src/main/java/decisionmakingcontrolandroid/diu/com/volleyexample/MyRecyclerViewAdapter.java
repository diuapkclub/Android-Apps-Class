package decisionmakingcontrolandroid.diu.com.volleyexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import decisionmakingcontrolandroid.diu.com.volleyexample.model.Contact;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    ArrayList<Contact> contactArrayList;
    Context context;

    public MyRecyclerViewAdapter(ArrayList<Contact> contactArrayList, Context context) {
        this.contactArrayList = contactArrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_contact_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact = contactArrayList.get(position);
        holder.tvId.setText(contact.getId());
        holder.tvName.setText(contact.getName());
        holder.tvEmail.setText(contact.getEmail());
        holder.tvAddress.setText(contact.getAddress());
        holder.tvGender.setText(contact.getGender());
        ArrayList<String> phone = contact.getPhone();
        holder.tvMobile.setText(phone.get(0));
        holder.tvHome.setText(phone.get(1));
        holder.tvOffice.setText(phone.get(2));
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName, tvEmail, tvAddress, tvGender, tvMobile, tvHome, tvOffice;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvGender = itemView.findViewById(R.id.tv_gender);
            tvMobile = itemView.findViewById(R.id.tv_mobile);
            tvHome = itemView.findViewById(R.id.tv_home);
            tvOffice = itemView.findViewById(R.id.tv_office);
        }
    }

}
