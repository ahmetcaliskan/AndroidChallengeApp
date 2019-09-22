package com.c.a.androidchallengeapp.utility;

import android.content.Context;

import com.c.a.androidchallengeapp.R;

public class UtilDate {

    public static String convertMonthName(Context context, String month) {
        String[] months = context.getResources().getStringArray(R.array.months);
        int resultMonth = Integer.parseInt(month) - 1;//aylar 1 eksik indeks'e karşılık geliyor. Ayrıca "01" veya "1" gelme durumu da kontrol edilmiş olacak

        try {//Herhangi bir yanlışlık durumunda boş gelsin. örn. servisten -1, 13 gibi değerler gelebilir. Crash engeli.
            return months[resultMonth];
        } catch (Exception e) {
            return "";
        }
    }
}
