package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ClassesInfo extends AppCompatActivity {

    ListView lvDailyGrade;
    Button btnInfo, btnEmail, btnAdd;
    ArrayAdapter<DailyCA> aa;
    ArrayList<DailyCA> grades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_info);

        Intent i = getIntent();
        i.getAction();

        lvDailyGrade = findViewById(R.id.ListViewDailyGrade);

        grades = new ArrayList<DailyCA>();

        aa = new ArrayAdapter<DailyCA>(this, R.layout.row, grades);
        lvDailyGrade.setAdapter(aa);

        btnInfo = findViewById(R.id.buttonInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                rpIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/full-time-diplomas/details/r47"));
                startActivity(rpIntent);
            }
        });

        btnEmail = findViewById(R.id.buttonEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "");
                email.putExtra(Intent.EXTRA_TEXT, "");
                // This MIME type indicates email
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });

        btnAdd = findViewById(R.id.buttonAdd);
    }
}
