package com.c.a.androidchallengeapp.utility.databinding;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

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
}

