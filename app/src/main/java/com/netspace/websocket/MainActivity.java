package com.netspace.websocket;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.UnknownHostException;

public class MainActivity extends Activity {

    public static class MainHandler extends Handler {
        public MainHandler(Looper mainLooper) {
            super(mainLooper);
        }
    }

    public IMWebSocketServer imWebSocketServer;
    public MainActivity.MainHandler mainHandler;
    public Button github;
    public EditText account;
    public Button remove_limit_hw;
    public Button wipe_data_hw;
    public Button enable_usb_hw;
    public Button remove_limit_lx;
    public Button wipe_data_lx;
    public Button enable_usb_lx;
    public Button wipe_data_sx;
    public Button remove_limit_sx;
    public Button lock_screen;
    public Button unlock_screen;
    public Button launch_activity;
    public Button send_message;
    public Button tablet_vibrator;
    public Button tablet_beep;
    public Button tablet_screen_on;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainHandler = new MainHandler(Looper.getMainLooper());
         account = findViewById(R.id.account);

         //跳转至项目地址
        github = findViewById(R.id.jump_to_git);
        github.setOnClickListener(view -> {
            Intent url = new Intent();
            url.setAction(Intent.ACTION_VIEW);
            url.setData(Uri.parse("https://github.com/HexoCustomPass/Myipad-WebSocket"));
            startActivity(url);
        });

         //华为解除限制
        remove_limit_hw = findViewById(R.id.remove_limit_hw);
        remove_limit_hw.setOnClickListener(view15 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"RunUrlScript https://github.com/HexoCustomPass/scrpit/blob/main/myihw.txt\",\"from\":\"system\"}")
        );
        //华为清除数据
        wipe_data_hw = findViewById(R.id.wipe_data_hw);
        wipe_data_hw.setOnClickListener(view17 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"RunScript b=Application.getClassLoader().loadClass('com.netspace.library.application.MyiBaseApplication');b.requestJavaMethod('getMethod',2);app=b.getMethod('getInstance', null).invoke(null,null);app.onSetupDeviceMDM().onWipe();\",\"from\":\"system\"}")
        );
        //华为启用usb调试
        enable_usb_hw = findViewById(R.id.enable_usb_hw);
        enable_usb_hw.setOnClickListener(view16 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"RunUrlScript https://github.com/HexoCustomPass/scrpit/blob/main/myhwusb.txt \",\"from\":\"system\"}")
        );
        //联想解除限制
        remove_limit_lx = findViewById(R.id.remove_limit_lx);
        remove_limit_lx.setOnClickListener(view18 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"RunUrlScript https://github.com/HexoCustomPass/scrpit/blob/main/myilx.txt \",\"from\":\"system\"}")
        );
        //联想清除数据
        wipe_data_lx = findViewById(R.id.wipe_data_lx);
        wipe_data_lx.setOnClickListener(view19 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"RunScript b=Application.getClassLoader().loadClass('com.netspace.library.application.MyiBaseApplication');b.requestJavaMethod('getMethod',2);app=b.getMethod('getInstance', null).invoke(null,null);app.onSetupDeviceMDM().onWipe();\",\"from\":\"system\"}")
        );
        //启用联想usb
        enable_usb_lx = findViewById(R.id.enable_usb_lx);
        enable_usb_lx.setOnClickListener(view110 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"RunUrlScript https://github.com/HexoCustomPass/scrpit/blob/main/mylxusb.txt\",\"from\":\"system\"}")
        );
        //三星清除数据
        wipe_data_sx = findViewById(R.id.wipe_data_sx);
        wipe_data_sx.setOnClickListener(view111 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"RunScript Application.getSystemService(\"enterprise_policy\").getSecurityPolicy().wipeDevice(1);\",\"from\":\"system\"}")
        );
        //三星解除限制
        remove_limit_sx = findViewById(R.id.remove_limit_sx);
        remove_limit_sx.setOnClickListener(view120 -> Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"RunUrlScript https://github.com/HexoCustomPass/scrpit/blob/main/myisx.txt\",\"from\":\"system\"}"));
        //锁定屏幕
        lock_screen = findViewById(R.id.lock_screen);
        lock_screen.setOnClickListener(view112 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"LockScreen\",\"from\":\"system\"}")
        );
        //解锁屏幕
        unlock_screen = findViewById(R.id.unlock_screen);
        unlock_screen.setOnClickListener(view113 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"UnLockScreen\",\"from\":\"system\"}")
        );
        //启动活动
        launch_activity = findViewById(R.id.launch_activity);
        launch_activity.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            final EditText editText = new EditText(MainActivity.this);
            editText.setText("'com.android.settings.DeviceAdminSettings‘, 'com.android.settings', null");
            builder.setTitle("启动指定活动");
            builder.setMessage("仿照输入提示替换活动即可");
            builder.setView(editText);
            builder.setPositiveButton("启动", (dialog, whichButton) -> Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"RunScript launchIntent" + "(" + editText.getText().toString()+ ")" + "\",\"from\":\"system\"}"));
            builder.show();
        });
        //发送信息
        send_message = findViewById(R.id.send_message);
        send_message.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            final EditText editText = new EditText(MainActivity.this);
            builder.setTitle("发送指定信息");
            builder.setView(editText);
            builder.setPositiveButton("发送", (dialog, whichButton) -> Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"ShowMessage " + editText.getText().toString()+ "\",\"from\":\"system\"}"));
            builder.show();
        });
        //平板震动
        tablet_vibrator = findViewById(R.id.tablet_vibrator);
        tablet_vibrator.setOnClickListener(view13 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"Vibrator\",\"from\":\"system\"}")
        );
        //平板响铃
        tablet_beep = findViewById(R.id.tablet_beep);
        tablet_beep.setOnClickListener(view12 ->
                Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"Beep\",\"from\":\"system\"}")
        );
        //平板亮屏
        tablet_screen_on = findViewById(R.id.screen_on);
        tablet_screen_on.setOnClickListener(view -> Broadcast("{\"guid\":\"357e6f2e7a0049ea8c9238eb1229cc39\",\"expire\":600,\"content\":\"Screen on\",\"from\":\"system\"}"));
    }

    public void startWebSocketServer(View view) throws UnknownHostException {
        imWebSocketServer = new IMWebSocketServer(8888, mainHandler);
        imWebSocketServer.start();
        Toast.makeText(MainActivity.this, "服务器已开启", Toast.LENGTH_LONG).show();
    }
    public void connect(View view) {
        if (imWebSocketServer == null) {
            Toast.makeText(this, "服务器未启动！", Toast.LENGTH_LONG).show();
            return;
        }
        WebSocketUtils.askMyiPadConnect(account.getText().toString(), WebSocketUtils.getIpAddress(this.getApplicationContext()), imWebSocketServer.getPort());
    }
    public void Broadcast(String Message) {
        if (imWebSocketServer == null) {
            Toast.makeText(MainActivity.this, "服务器未启动！", Toast.LENGTH_LONG).show();
        }
        else imWebSocketServer.broadcast(Message);
    }
}