import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wearepkk.R;

public class PediaItem extends AppCompatActivity {

    TextView view2;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_pedia_item);


        view2 = findViewById(R.id.text_view_desc_pedia);
        show = findViewById(R.id.show_more);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view2.setVisibility((view2.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
            }
        });
    }
}
