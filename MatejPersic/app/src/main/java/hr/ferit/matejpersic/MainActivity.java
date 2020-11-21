package hr.ferit.matejpersic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements NameClickListener {
    //declaring variables
    private EditText editText;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        setupRecyclerData();
    }
    private void setupRecycler(){
        //initializing variables, recycleView and recyclerAdapter
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter=new RecyclerAdapter(this);
        recyclerView.setAdapter(recyclerAdapter);
        editText=findViewById(R.id.editText);
    }
    private void setupRecyclerData(){
        //setting up gimmick data and adding it to the view via adapter
        List<String> data=new ArrayList<>();
        data.add("Ana");
        data.add("Pero");
        data.add("Stjepan");
        data.add("Filip");
        recyclerAdapter.addData(data);
    }

    public void addCell(View view){
        //onClick method for button (id addButton)
        String studentName=editText.getText().toString();
        if(!studentName.isEmpty())
        recyclerAdapter.addNewCell(studentName,recyclerAdapter.getItemCount());
        editText.setText("");
    }

    @Override
    public void onNameClick(int position) {
        recyclerAdapter.removeCell(position);
    }
}