package com.c.a.androidchallengeapp.utility.databinding;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.c.a.androidchallengeapp.R;
import com.c.a.androidchallengeapp.types.TypeProductState;
import com.c.a.androidchallengeapp.utility.UtilDate;
import com.google.android.material.textfield.TextInputLayout;

public class UtilBindingAdapter {

    @BindingAdapter({"setFont"})
    public static void setFont(View v, String fontFile) {
        String path = "fonts/" + fontFile;
        Typeface face = Typeface.createFromAsset(v.getContext().getAssets(), path);

        if (v instanceof TextView)
            ((TextView) v).setTypeface(face);

        if (v instanceof Button)
            ((Button) v).setTypeface(face);

        if (v instanceof EditText)
            ((EditText) v).setTypeface(face);

        if (v instanceof Switch)
            ((Switch) v).setTypeface(face);

        if (v instanceof CheckBox)
            ((CheckBox) v).setTypeface(face);

        if (v instanceof TextInputLayout)
            ((TextInputLayout) v).setTypeface(face);

        if (v instanceof RadioButton)
            ((RadioButton) v).setTypeface(face);
    }

    @BindingAdapter({"setTextColorByState"})
    public static void setTextColorByState(TextView tv, String state) {
        switch (state) {
            case TypeProductState.PREPARING:
                tv.setText("*Hazırlanıyor");
                tv.setTextColor(ContextCompat.getColor(tv.getContext(), R.color.flat_my_sunset));
                tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(tv.getContext(),
                        R.drawable.ic_square_state_preparing),
                        null, null, null);
                break;
            case TypeProductState.PENDING_APPROVAL:
                tv.setText("Onay Bekliyor");
                tv.setTextColor(ContextCompat.getColor(tv.getContext(), R.color.flat_my_brick_red));
                tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(tv.getContext(),
                        R.drawable.ic_square_state_pending),
                        null, null, null);
                break;
            case TypeProductState.SENT:
                tv.setText("Yolda");
                tv.setTextColor(ContextCompat.getColor(tv.getContext(), R.color.flat_my_grass));
                tv.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(tv.getContext(),
                        R.drawable.ic_square_state_sent),
                        null, null, null);
                break;
            default:
                break;
        }
    }

    @BindingAdapter({"setTextConvertMonthName"})
    public static void setTextConvertMonthName(TextView tv, String month) {
        tv.setText(UtilDate.convertMonthName(month));
    }
}

