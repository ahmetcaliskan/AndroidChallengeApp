package com.c.a.androidchallengeapp.types;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@StringDef({TypeProductState.PREPARING, TypeProductState.PENDING_APPROVAL, TypeProductState.SENT})
@Retention(RetentionPolicy.SOURCE)
public @interface TypeProductState {//Özel unique kodları (Örn 1,2 gibi) olmadığı için mecbur string kontrolü yapılacak.
    String PREPARING = "Hazırlanıyor";
    String PENDING_APPROVAL = "Onay Bekliyor";
    String SENT = "Yolda";
}