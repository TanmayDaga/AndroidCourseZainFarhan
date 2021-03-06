package com.example.android.background.sync;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.android.background.utilities.NotificationUtils;
import com.example.android.background.utilities.PreferenceUtilities;

public class ReminderTasks{

    public static final String ACTION_INCREMENT_WATER_COUNT = "increment-water-count";
    public static final String ACTION_DISMISS_NOTIFICATION = "dismiss-notfictions";
    public static final String ACTION_CHARGING_REMINDER = "charging-reminder";
    public static void executeTask(Context context,String action){
        if (ACTION_INCREMENT_WATER_COUNT.equals(action))
        {
            incrementWaterCount(context);

        }
        else if(ACTION_DISMISS_NOTIFICATION.equals(action)){
            NotificationUtils.clearAllNotification(context);
        }
        else if(ACTION_CHARGING_REMINDER.equals(action)){
            issueChargingReminder(context);
        }
    }

    private static void issueChargingReminder(Context context) {

        PreferenceUtilities.incrementChargingReminderCount(context);
        NotificationUtils.remindUserBecauseCharging(context);
    }

    private static void incrementWaterCount(Context context) {

        PreferenceUtilities.incrementWaterCount(context);
        NotificationUtils.clearAllNotification(context);

    }





}

