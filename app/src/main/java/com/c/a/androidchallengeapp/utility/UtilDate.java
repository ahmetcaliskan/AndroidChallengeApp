package com.c.a.androidchallengeapp.utility;

public class UtilDate {

    public static String convertMonthName(String month) {
        switch (month) {
            case "01":
                return "Ocak";
            case "02":
                return "Şubat";
            case "03":
                return "Mart";
            case "04":
                return "Nisan";
            case "05":
                return "Mayıs";
            case "06":
                return "Haziran";
            case "07":
                return "Temmuz";
            case "08":
                return "Ağustos";
            case "09":
                return "Eylül";
            case "10":
                return "Ekim";
            case "11":
                return "Kasım";
            case "12":
                return "Aralık";
        }
        return "";
    }

}
