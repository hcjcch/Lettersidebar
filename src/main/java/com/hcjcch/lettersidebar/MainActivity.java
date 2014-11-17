/* Copyright (C) 2012 The Android Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.hcjcch.lettersidebar;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;


public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res = getResources();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        WeiXinMailList weiXinMailList = (WeiXinMailList)findViewById(R.id.weixin);
        final TextView textView = (TextView)findViewById(R.id.letter);
        weiXinMailList.setInterFace(new WeiXinMailList.CallBack() {
            @Override
            public void callBack(int yPosition) {
                textView.setText(String.valueOf((char) ('A' + yPosition)));
            }
        });
    }
}

