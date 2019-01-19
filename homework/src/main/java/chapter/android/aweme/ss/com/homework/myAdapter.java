package chapter.android.aweme.ss.com.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;

public class myAdapter extends RecyclerView.Adapter<myAdapter.VIEW_HOLDER> {
   List<Message> mData;
    public myAdapter(List<Message> data)
    {
        mData=data;
    }


    @NonNull
    @Override
    public VIEW_HOLDER onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_item,viewGroup,false);
        VIEW_HOLDER viewhoder = new VIEW_HOLDER(view);
        Log.d("Text","onCreat");
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull VIEW_HOLDER view_holder, int position) {
        Message message = mData.get(position);
        VIEW_HOLDER.updateUI(message);
        Log.d("Text","onBind");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class VIEW_HOLDER extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static TextView hp_name;
        private static TextView hp_message;
        private static TextView hp_time;
        private chapter.android.aweme.ss.com.homework.widget.CircleImageView hp_icon;

        public VIEW_HOLDER(@NonNull View itemView) {
            super(itemView);
            hp_name = (TextView)itemView.findViewById(R.id.ph_id);
            hp_message = (TextView)itemView.findViewById(R.id.ph_message);
            hp_time = (TextView) itemView.findViewById(R.id.ph_time);
            hp_icon = (chapter.android.aweme.ss.com.homework.widget.CircleImageView) itemView.findViewById(R.id.ph_icon);

        }

        public static void updateUI(Message message) {
            hp_name.setText(message.getTitle());
            hp_message.setText(message.getDescription());
            hp_time.setText(message.getTime());

        }

        @Override
        public void onClick(View v) {

        }
    }
}
