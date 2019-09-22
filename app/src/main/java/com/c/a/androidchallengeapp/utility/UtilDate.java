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

//        switch (month) {
//            case "01":
//                return "Ocak";
//            case "02":
//                return "Şubat";
//            case "03":
//                return "Mart";
//            case "04":
//                return "Nisan";
//            case "05":
//                return "Mayıs";
//            case "06":
//                return "Haziran";
//            case "07":
//                return "Temmuz";
//            case "08":
//                return "Ağustos";
//            case "09":
//                return "Eylül";
//            case "10":
//                return "Ekim";
//            case "11":
//                return "Kasım";
//            case "12":
//                return "Aralık";
//        }
//        return "";
    }

}
