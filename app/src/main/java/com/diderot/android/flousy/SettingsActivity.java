package com.diderot.android.flousy;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import flousy.tool.Session;
import flousy.gui.actionbar.ActionBar;
import flousy.gui.app.KeyboardManager;
import flousy.content.user.User;
import flousy.tool.FormValidator;

public class SettingsActivity extends MotherActivity {

    public static final int ACTIVITY_COLOR = R.color.customBrown;

    private class ViewHolder {
        public EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
        public CheckBox connectCheckBox;
    }

    private ViewHolder formUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set ActivityContent
        setContentView(R.layout.form_user_layout);

        //Set activity color immediately after content view
        setActivityColor(getResources().getColor(ACTIVITY_COLOR));

        //Set ActionBar
        ActionBar actionBar = getCustomActionBar();
        actionBar.getTitleView().setText(R.string.activity_settings_name);

        //Set ActivityContent
        this.formUser = new ViewHolder();

        this.formUser.firstNameEditText = (EditText) findViewById(R.id.form_user_edittext_firstname);
        this.formUser.lastNameEditText = (EditText) findViewById(R.id.form_user_edittext_lastname);
        this.formUser.emailEditText = (EditText) findViewById(R.id.form_user_edittext_email);
        this.formUser.passwordEditText = (EditText) findViewById(R.id.form_user_edittext_password);

        TextView.OnEditorActionListener listener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    KeyboardManager.hide(v);
                    updateUser();
                    return true;
                }
                return false;
            }
        };

        this.formUser.firstNameEditText.setOnEditorActionListener(listener);
        this.formUser.lastNameEditText.setOnEditorActionListener(listener);
        this.formUser.emailEditText.setOnEditorActionListener(listener);

        this.formUser.connectCheckBox = (CheckBox) findViewById(R.id.form_user_checkbox);
        TextView validCheckBoxTextView = (TextView) findViewById(R.id.form_user_textview_validcheckbox);
        validCheckBoxTextView.setText(R.string.settings_form_user_textview_validcheckbox_connect);

        //Customize activity
        customizeColor();
        customizeText();
        customizeDimensions();
    }

    @Override
    protected void onStart() {
        super.onStart();

        loadUser();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    public void loadUser() {
        Session session = new Session(this);
       // DataManager data = new DataManager(this);

       // User user = data.getUser(session.getUserEmail());
        boolean stayConnect = true;

       // this.form.firstNameEditText.setText(user.getFirstName(), TextView.BufferType.EDITABLE);
        //this.form.lastNameEditText.setText(user.getLastName(), TextView.BufferType.EDITABLE);
        //this.form.emailEditText.setText(user.getEmail(), TextView.BufferType.EDITABLE);
        this.formUser.passwordEditText.setText("", TextView.BufferType.EDITABLE);
       this.formUser.connectCheckBox.setChecked(stayConnect);
    }

    public void updateUser() {
        Session session = new Session(this);
      //  DataManager data = new DataManager(this);

        String firstName = this.formUser.firstNameEditText.getEditableText().toString();
        String lastName = this.formUser.lastNameEditText.getEditableText().toString();
        String email = this.formUser.emailEditText.getEditableText().toString();
        String password = "password";
        Boolean connectCheckBox = this.formUser.connectCheckBox.isChecked();

        String phoneNumber = "0000";
        Drawable image = null;

        User user = new User(firstName, lastName, phoneNumber, email, password, image);

        boolean valid = FormValidator.validUser(user);
       // if(valid == true) {
         //   User user = new User(firstName, lastName, phoneNumber, email, password, image);
    //appeler la base pour mettre a jour les données de l'utilisateur
           // if(updated == true) {
          //      session.updateSession(user.getEmail());
           // }
        //}
    }
}