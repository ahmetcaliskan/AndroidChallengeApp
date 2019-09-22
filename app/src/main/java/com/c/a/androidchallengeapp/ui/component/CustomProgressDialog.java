package com.c.a.androidchallengeapp.ui.component;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.c.a.androidchallengeapp.R;
import com.c.a.androidchallengeapp.databinding.CustomProgressDialogBinding;


public class CustomProgressDialog extends Dialog implements View.OnClickListener {

    private CustomProgressDialogBinding binding;
    private int rawResId;
    private String message;
    private boolean cancelable;
    private CustomListener listener;

    public CustomProgressDialog(@NonNull Context context, int rawResId, String message, boolean cancelable, CustomListener listener) {//Context parametresine activity gönderilmeli, token null hatası
        super(context);
        this.rawResId = rawResId;
        this.message = message;
        this.cancelable = cancelable;
        this.listener = listener;
    }

    public CustomProgressDialog(@NonNull Context context, int themeResId, int rawResId, String message, boolean cancelable, CustomListener listener) {
        super(context, themeResId);
        this.rawResId = rawResId;
        this.message = message;
        this.cancelable = cancelable;
        this.listener = listener;
    }

    protected CustomProgressDialog(@NonNull Context context, boolean cancelable, int rawResId, @Nullable OnCancelListener cancelListener, String message, boolean cancelable1, CustomListener listener) {
        super(context, cancelable, cancelListener);
        this.rawResId = rawResId;
        this.message = message;
        this.cancelable = cancelable1;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();

        if (window != null)
            window.setBackgroundDrawableResource(R.color.transparent_white_00);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.custom_progress_dialog, null, false);
        setContentView(binding.getRoot());

        binding.btnCancel.setOnClickListener(this);

        if (cancelable)
            binding.btnCancel.setVisibility(View.GONE);

        binding.lottieAnimationView.setAnimation(rawResId);
        binding.tvMessage.setText(message);

        setCancelable(cancelable);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancel:
                if (listener != null)
                    listener.cancel();
                break;
            default:
                break;
        }
    }

    public interface CustomListener {
        void cancel();
    }
}
