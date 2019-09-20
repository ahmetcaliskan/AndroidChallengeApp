package com.c.a.androidchallengeapp.types;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({TypeFont.DEFAULT, TypeFont.DEFAULT_BOLD})
@Retention(RetentionPolicy.SOURCE)
public @interface TypeFont {
    String DEFAULT = "bariol_regular.otf";
    String DEFAULT_BOLD = "bariol_bold.otf";
}