package receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.numapp.schif.numapp.MainActivity;

/**
 * Created by kevin on 22/10/2016.
 */

public class LockScreenReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        //If the screen was just turned on or it just booted up, start your Lock Activity
        if(action.equals(Intent.ACTION_SCREEN_OFF) || action.equals(Intent.ACTION_BOOT_COMPLETED))
        {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
