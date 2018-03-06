package com.example.cache;

import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class PreferenceHelper {

  private static final String PREF_LAST_CACHE = "last_cache";
  private static  String PREF_NAME;
  private Context context;
  private SharedPreferences sharedPreferences;

  @Inject
  public PreferenceHelper(Context context) {
    this.context = context;
    PREF_NAME = context.getPackageName();
    sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
  }

  public void setCacheTime(long time) {
    sharedPreferences.edit().putLong(PREF_LAST_CACHE, time);
  }

  public long getLastCacheTime() {
    return sharedPreferences.getLong(PREF_LAST_CACHE, 0);
  }


}
