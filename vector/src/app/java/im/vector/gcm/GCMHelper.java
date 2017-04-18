/* 
 * Copyright 2014 OpenMarket Ltd
 * Copyright 2017 Vector Creations Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package im.vector.gcm;

import android.content.Context;

import org.matrix.androidsdk.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

public class GCMHelper {

    private static final String LOG_TAG = "GCMHelper";

    /**
     * Retrieves the GCM registration token.
     *
     * @return the registration token.
     */
    public static String getRegistrationToken(Context context) {
        String registrationToken;

        try {
            FirebaseApp.initializeApp(context);
            registrationToken = FirebaseInstanceId.getInstance().getToken();
            Log.d(LOG_TAG, "## getRegistrationToken(): " + registrationToken);
        } catch (Exception e) {
            Log.e(LOG_TAG, "getRegistrationToken() : failed " + e.getMessage());
            registrationToken = null;
        }

        return registrationToken;
    }

    /**
     * Clear the registration token.
     */
    public static void clearRegistrationToken() {
        try {
            FirebaseInstanceId.getInstance().deleteInstanceId();
        } catch (Exception e) {
            Log.e(LOG_TAG, "##clearRegistrationToken() failed " + e.getMessage());
        }
    }
}
