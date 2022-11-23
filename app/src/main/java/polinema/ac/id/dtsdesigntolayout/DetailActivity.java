package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView nama, nomor;
    ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nama = findViewById(R.id.det_nama);
        nomor = findViewById(R.id.det_nomor);
        gambar = findViewById(R.id.det_img);

        nama.setText(getIntent().getExtras().getString("nama"));
        nomor.setText(getIntent().getExtras().getString("nomor"));

        String imageUrl = getIntent().getStringExtra("gambar");
        Picasso.get().load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(gambar);

    }

    public void clickBack(View view) {
        Intent i = new Intent(DetailActivity.this, SuccessActivity.class);
        startActivity(i);
    }
}