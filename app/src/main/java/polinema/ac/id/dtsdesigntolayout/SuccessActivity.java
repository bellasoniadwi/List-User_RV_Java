package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SuccessActivity extends AppCompatActivity implements ContactAdapter.OnContactClickListener{

    public RecyclerView rv;
    public ContactAdapter contactAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Contact> listContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        rv = findViewById(R.id.rvContact);

        listContact.add(new Contact("Iron Man",
                "102018308",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-14-512.png"));

        listContact.add(new Contact("Bat Man",
                "102018309",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-22-512.png"));

        listContact.add(new Contact("Groot",
                "102018307",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-21-512.png"));

        listContact.add(new Contact("Sonic",
                "102018301",
                "https://cdn4.iconfinder.com/data/icons/famous-characters-add-on-vol-1-flat/48/Famous_Character_-_Add_On_1-26-512.png"));

        listContact.add(new Contact("Doctor",
                "102018301",
                "https://cdn2.iconfinder.com/data/icons/health-care-and-first-responders/64/doctor-white-female-coronavirus-512.png"));

        listContact.add(new Contact("Police",
                "102018301",
                "https://cdn2.iconfinder.com/data/icons/health-care-and-first-responders/64/police-asian-female-coronavirus-512.png"));

        listContact.add(new Contact("Soldier",
                "102018301",
                "https://cdn4.iconfinder.com/data/icons/scenarium-vol-6/128/016_military_soldier_man-512.png"));

        listContact.add(new Contact("Courier",
                "102018301",
                "https://cdn4.iconfinder.com/data/icons/occupation-set1-man/504/Messenger-mailman-deliveryman-courier-service-512.png"));

        listContact.add(new Contact("Chef",
                "102018301",
                "https://cdn2.iconfinder.com/data/icons/dompicon-tint-female-profession/256/chef-cook-profession-female-avatar-512.png"));


        contactAdapter = new ContactAdapter(listContact);
        contactAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(contactAdapter);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view, int position) {
        Contact contact = listContact.get(position);
//        Toast.makeText(this, contact.getName(), Toast.LENGTH_SHORT)
//                .show();
        Intent intent = new Intent(view.getContext(), DetailActivity.class);
        intent.putExtra("nama", contact.getName());
        intent.putExtra("nomor", contact.getPhone());
        intent.putExtra("gambar", contact.getImageUrl());

        view.getContext().startActivity(intent);
    }

    public void clickLogout(View view) {
        Intent i = new Intent(SuccessActivity.this, WelcomeBack.class);
        startActivity(i);
    }
}
