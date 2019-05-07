package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayAdapter<String> aa;
    ArrayList<String> classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = findViewById(R.id.listViewModule);

        classes = new ArrayList<String>();
        classes.add("C347");

        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, classes);
        lvModule.setAdapter(aa);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, ClassesInfo.class);
                startActivity(i);
            }
        });

    }
}
