package thanhdnh.ueh.edu.article_app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ViewUserActivity extends AppCompatActivity {

  ImageView iv_detail;

  TextView tv_detail_username;
  TextView tv_detail_email;
  TextView tv_detail_desc;
  TextView tv_detail_hobby;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(
            R.layout.activity_view_user
    );

    getSupportActionBar().hide();

    iv_detail =
            findViewById(R.id.iv_detail);

    tv_detail_username =
            findViewById(
                    R.id.tv_detail_username
            );

    tv_detail_email =
            findViewById(
                    R.id.tv_detail_email
            );

    tv_detail_desc =
            findViewById(
                    R.id.tv_detail_desc
            );

    tv_detail_hobby =
            findViewById(
                    R.id.tv_detail_hobby
            );

    int id =
            (int) getIntent()
                    .getLongExtra(
                            "id",
                            0
                    );

    UserProfile user =
            UserData.getUserFromId(id);

    if (user != null) {

      Picasso.get()
              .load(user.getAvatar_url())
              .resize(400, 500)
              .centerCrop()
              .into(iv_detail);

      tv_detail_username.setText(
              user.getUsername()
      );

      tv_detail_email.setText(
              user.getEmail()
      );

      tv_detail_desc.setText(
              user.getDesc()
      );

      tv_detail_hobby.setText(
              user.getHobby()
      );
    }
  }
}

