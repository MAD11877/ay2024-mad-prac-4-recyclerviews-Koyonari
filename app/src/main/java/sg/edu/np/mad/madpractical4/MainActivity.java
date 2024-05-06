package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Intialize a new User object
        User user = new User("John Doe", "MAD Developer", 1, false);

        // Get the TextViews and Button from Layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        // Onclick listener to change button text and show toast
        btnFollow.setOnClickListener(v -> {
            String newButtonText;
            CharSequence toastText;

            if (btnFollow.getText().toString().equals("Follow")) {
                newButtonText = "Unfollow";
                toastText = "Followed";
            } else {
                newButtonText = "Follow";
                toastText = "Unfollowed";
            }

            btnFollow.setText(newButtonText);
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(this, toastText, duration).show();
        });

        // Set the TextViews with the User's name, description, default button message
        int randomInteger = getIntent().getIntExtra("randomInteger", 0);
        tvName.setText(user.name + " " + randomInteger);
        tvDescription.setText(user.description);
    }
}