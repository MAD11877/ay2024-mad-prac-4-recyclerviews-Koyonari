package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonFollow;
    private TextView tvName, tvDescription;
    private boolean followed;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        tvName = findViewById(R.id.tvName);
        tvDescription = findViewById(R.id.tvDescription);
        buttonFollow = findViewById(R.id.btnFollow);

        // Get user information from intent
        Intent intent = getIntent();
        if (intent != null) {
            currentUser = (User) intent.getSerializableExtra("user");
            if (currentUser != null) {
                // Set user information
                tvName.setText(currentUser.getName());
                tvDescription.setText(currentUser.getDescription());
                // Set initial follow state
                followed = currentUser.getFollowed();
                setupFollowButton();
            }
        }
    }

    private void setupFollowButton() {
        buttonFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newButtonText;
                CharSequence toastText;

                if (buttonFollow.getText().toString().equals("Follow")) {
                    newButtonText = "Unfollow";
                    toastText = "Followed";
                } else {
                    newButtonText = "Follow";
                    toastText = "Unfollowed";
                }

                buttonFollow.setText(newButtonText);
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(MainActivity.this, toastText, duration).show();
            }
        });
    }
}