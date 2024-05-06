package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ImageView;
import java.util.Random;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Create a list of 20 User randomized objects
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < 20; i++){
            int num = new Random().nextInt(999999999);
            int dnum = new Random().nextInt(999999999);
            int inum = new Random().nextInt(99999);
            String nm = "Name " + num;
            String description = "Description " + dnum;
            Boolean follow = new Random().nextBoolean();
            User user = new User(nm, description, inum, follow);
            users.add(user);
        };

        //RecyclerView
        UserAdapter userAdapter = new UserAdapter(users, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        /*
        ImageView btn = findViewById(R.id.centerlogo);
        btn.setOnClickListener(v -> {
            // Create the object of AlertDialog Builder class
            AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
            builder.setMessage("MADness");
            builder.setTitle("Profile");
            // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
            builder.setCancelable(true);
            // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
            builder.setNegativeButton("Close", (DialogInterface.OnClickListener) (dialog, which) -> {
                finish();
            });
            // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
            builder.setPositiveButton("View", (DialogInterface.OnClickListener) (dialog, which) -> {
                dialog.cancel();
                int rnum = new Random().nextInt(99999);
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("randomInteger", rnum); // Pass random integer as extra
                startActivity(intent); // Launch MainActivity
            });
            // Create the Alert dialog
            AlertDialog alertDialog = builder.create();
            // Show the Alert Dialog box
            alertDialog.show();
        });

         */
    }
}