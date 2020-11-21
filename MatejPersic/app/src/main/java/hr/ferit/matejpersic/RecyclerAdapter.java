package hr.ferit.matejpersic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
//adapter takes care of creating ViewHolder and storing data for RecyclerView
public class RecyclerAdapter extends RecyclerView.Adapter<NameViewHolder> {
    private List<String> dataList=new ArrayList<>();
    private NameClickListener clickListener;

    public RecyclerAdapter(NameClickListener listener){ this.clickListener=listener;}

    @NonNull
    @Override
    //method for creating and recycling viewholder
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_name,parent,false);
        return new NameViewHolder(cellView, clickListener);
    }

    @Override
    //method for connecting ViewHolder and data in the adapter
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(dataList.get(position));
    }

    //number of elements in recyclerview
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(List<String> data){
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }
    public void addNewCell(String name, int position){
        if(dataList.size()>=position){
            dataList.add(position,name);
            notifyItemInserted(position);
        }
    }
    public void removeCell(int position){
        if(dataList.size()>position){
            dataList.remove(position);
            notifyItemRemoved(position);
        }
    }
}
