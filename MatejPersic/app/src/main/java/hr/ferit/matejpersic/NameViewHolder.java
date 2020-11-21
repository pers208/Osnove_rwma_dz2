package hr.ferit.matejpersic;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView textView;
    private ImageView imageView;
    private NameClickListener clickListener;

    public NameViewHolder(@NonNull View itemView, NameClickListener listener) {
        super(itemView);
        this.clickListener=listener;
        imageView=itemView.findViewById(R.id.tvX);
        textView =itemView.findViewById(R.id.tvName);
        imageView.setOnClickListener(this);
    }

    public void setName(String name){
        textView.setText(name);
    }

    @Override
    public void onClick(View v) {
        Log.d("tag ","onClick(v)");
        clickListener.onNameClick(getAdapterPosition());
    }
}
