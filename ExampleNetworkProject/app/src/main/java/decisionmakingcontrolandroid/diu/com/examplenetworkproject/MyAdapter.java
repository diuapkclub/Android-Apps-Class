package decisionmakingcontrolandroid.diu.com.examplenetworkproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Student> studentArrayList;
    Context context;

    public MyAdapter(ArrayList<Student> studentArrayList, Context context) {
        this.studentArrayList = studentArrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_settings, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student student = studentArrayList.get(position);
        holder.tvStudentName.setText(student.getName());
        holder.tvEamil.setText(student.getEmail());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView tvStudentName, tvEamil;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvStudentName = itemView.findViewById(R.id.tv_name);
            tvEamil = itemView.findViewById(R.id.tv_email);

        }
    }
}