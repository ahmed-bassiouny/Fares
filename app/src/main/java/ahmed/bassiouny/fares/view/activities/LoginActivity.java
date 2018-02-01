package ahmed.bassiouny.fares.view.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.request.RequestAndResponse;
import ahmed.bassiouny.fares.model.User;
import ahmed.bassiouny.fares.utils.MyProgressBar;
import ahmed.bassiouny.fares.utils.UserSharedPref;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int RC_SIGN_IN = 5;
    private GoogleSignInOptions gso;
    private FirebaseAuth mAuth;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MyProgressBar.setActivity(this);
        findViewById(R.id.btn_gmail).setOnClickListener(this);
        findViewById(R.id.btn_facebook).setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null)
            updateUI();

    }

    private void updateUI(){
        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
        finish();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_gmail:
                MyProgressBar.show();
                configurationGoogle();
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);
                break;
            case R.id.btn_facebook:
                //TODO implement
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                MyProgressBar.hide();
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();
                            RequestAndResponse.loginUser(user.getUid(), user.getDisplayName(), user.getEmail(), "", new BaseResponseInterface<User>() {
                                @Override
                                public void onSuccess(User user) {
                                    UserSharedPref.setUserInfo(LoginActivity.this,user.getApiToken(),user.isHasShop(),user.getId(),user.isOnline());
                                    MyProgressBar.hide();
                                    updateUI();
                                }

                                @Override
                                public void onFailed(String errorMessage) {
                                    Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                                    MyProgressBar.hide();
                                }
                            });
                        } else {

                            Toast.makeText(LoginActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            MyProgressBar.hide();
                        }
                    }
                });
    }

    private void configurationGoogle() {
        mAuth = FirebaseAuth.getInstance();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }
}
