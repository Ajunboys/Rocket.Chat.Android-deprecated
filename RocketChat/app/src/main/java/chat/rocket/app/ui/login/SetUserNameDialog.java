package chat.rocket.app.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import chat.rocket.app.R;
import chat.rocket.operations.methods.RocketMethods;
import chat.rocket.operations.methods.listeners.LogListener;

/**
 * Created by julio on 25/11/15.
 */
public class SetUserNameDialog extends DialogFragment {
    public static final String SUGGESTION = "suggestion";
    private TextInputLayout mUsernameTextInputLayout;

    public interface SetUsernameCallback {
        void onSuccess(String name);

        RocketMethods getRocketMethods();
    }

    private SetUsernameCallback mCallback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_set_name, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUsernameTextInputLayout = (TextInputLayout) view.findViewById(R.id.UsernameTextInputLayout);
        EditText usernameEditText = (EditText) view.findViewById(R.id.UsernameEditText);
        String suggestion = getArguments().getString(SUGGESTION);
        usernameEditText.setText(suggestion);
        usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUsernameTextInputLayout.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        view.findViewById(R.id.CancelButton).setOnClickListener(v -> {
            dismiss();
        });
        view.findViewById(R.id.OkButton).setOnClickListener(v -> {
            setUsername(usernameEditText.getText().toString());
        });
    }

    private void setUsername(String name) {
        mCallback.getRocketMethods().setUsername(name, new LogListener("saveuserprofile") {
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                mCallback.onSuccess(name);
                dismiss();
            }

            @Override
            public void onError(String error, String reason, String details) {
                super.onError(error, reason, details);
                mUsernameTextInputLayout.setErrorEnabled(true);
                mUsernameTextInputLayout.setError(error + ", " + reason + ", " + details);
            }
        });

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (SetUsernameCallback) activity;
    }
}
