package ahmed.bassiouny.fares.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by bassiouny on 02/01/18.
 */

public class UserSharedPref {

    private final static String sharedPrefName = "Fares";
    private final static String API_TOKEN = "api_token";
    private final static String NOTIFICATION_TOKEN = "notification_token";
    private final static String TOKEN_HEADER_KEY = "Bearer ";
    private final static String USER_HAS_SHOP = "has_shop";
    private final static String USER_ID = "user_id";
    private final static String IS_ONLINE = "is_online";

    private static SharedPreferences sharedPref;

    private static void getSharedPref(Context context) {
        if (sharedPref == null)
            sharedPref = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
    }

    public static void setUserInfo(Context context, String apiToken, boolean hasShop, int userId, boolean isOnline) {
        getSharedPref(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(API_TOKEN, apiToken);
        editor.putBoolean(USER_HAS_SHOP, hasShop);
        editor.putInt(USER_ID, userId);
        editor.putBoolean(IS_ONLINE, isOnline);
        editor.apply();
    }

    public static void setUserHasShop(Context context, boolean hasShop) {
        getSharedPref(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(USER_HAS_SHOP, hasShop);
        editor.apply();
    }

    public static void setUserOnline(Context context, boolean online) {
        getSharedPref(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(IS_ONLINE, online);
        editor.apply();
    }

    public static boolean getUserHasShop(Context context) {
        getSharedPref(context);
        return sharedPref.getBoolean(USER_HAS_SHOP, false);
    }

    public static boolean getUserOnline(Context context) {
        getSharedPref(context);
        return sharedPref.getBoolean(IS_ONLINE, false);
    }

    public static int getUserId(Context context) {
        getSharedPref(context);
        return sharedPref.getInt(USER_ID, 0);
    }

    public static void setNotificationToken(Context context, String notificationToken) {
        getSharedPref(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(NOTIFICATION_TOKEN, notificationToken);
        editor.apply();
    }

    public static String getTokenWithHeader(Context context) {
        getSharedPref(context);
        return TOKEN_HEADER_KEY + sharedPref.getString(API_TOKEN, "");
    }
}
