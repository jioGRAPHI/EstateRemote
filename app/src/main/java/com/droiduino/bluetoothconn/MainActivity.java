package com.droiduino.bluetoothconn;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private String cmd = "";
    private String cmdText = "";
    private String all_stat, random_stat, landscape_stat, lobby_stat, secondFloor_stat, typicalFloor_stat, amenity_stat, amenityPenthouse_stat,street_stat,
            ayalaSide_stat, ritzSide_stat, urdanetaSide_stat, discoveryPrimeaSide_stat, garden_stat, playArea_stat, wineTasting_stat, outdoorLounge_stat,
            wineCellar_stat, businessCentre_stat, fitnessCentre_stat, atriumLounge_stat, pavillionLounge_stat, arrivalLounge_stat, pianoLounge_stat, poolDeck_stat;
    private boolean initial_click = true;
    private String deviceName = null;
    private String deviceAddress;
    public static Handler handler;
    public static BluetoothSocket mmSocket;
    public static ConnectedThread connectedThread;
    public static CreateConnectThread createConnectThread;

    public static Handler handlerGround;
    public static BluetoothSocket mmSocketGround;
    public static ConnectedThreadGround connectedThreadGround;
    public static CreateConnectThreadGround createConnectThreadGround;

    public static Handler handlerSecond;
    public static BluetoothSocket mmSocketSecond;
    public static ConnectedThreadSecond connectedThreadSecond;
    public static CreateConnectThreadSecond createConnectThreadSecond;

    public static Handler handlerAmenity;
    public static BluetoothSocket mmSocketAmenity;
    public static ConnectedThreadAmenity connectedThreadAmenity;
    public static CreateConnectThreadAmenity createConnectThreadAmenity;

    public static Handler handlerTypical;
    public static BluetoothSocket mmSocketTypical;
    public static ConnectedThreadTypical connectedThreadTypical;
    public static CreateConnectThreadTypical createConnectThreadTypical;


    private Handler mHandler;
    private Runnable mRunnable;

    private final static int CONNECTING_STATUS = 1; // used in bluetooth handler to identify message status
    private final static int MESSAGE_READ = 2; // used in bluetooth handler to identify message update

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ALL_PERMISSION();
        // UI Initialization
        final Button buttonConnect = findViewById(R.id.buttonConnect);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        final TextView textViewInfo = findViewById(R.id.textViewInfo);
        //final ImageView imageView = findViewById(R.id.imageView);
        //imageView.setBackgroundColor(getResources().getColor(R.color.colorOff));

        all_stat = "off";
        random_stat = "off";
        landscape_stat = "off";
        lobby_stat = "off";
        street_stat = "off";
        secondFloor_stat = "off";
        typicalFloor_stat = "off";
        amenity_stat = "off";
        amenityPenthouse_stat = "off";
        ayalaSide_stat = "off";
        ritzSide_stat = "off";
        urdanetaSide_stat = "off";
        discoveryPrimeaSide_stat = "off";
        garden_stat = "off";
        playArea_stat = "off";
        wineTasting_stat = "off";
        outdoorLounge_stat = "off";
        wineCellar_stat = "off";
        businessCentre_stat = "off";
        fitnessCentre_stat = "off";
        atriumLounge_stat = "off";
        pavillionLounge_stat = "off";
        arrivalLounge_stat = "off";
        pianoLounge_stat = "off";
        poolDeck_stat = "off";

        // If a bluetooth device has been selected from SelectDeviceActivity
        deviceName = getIntent().getStringExtra("deviceName");
        if (deviceName != null) {
            // Get the device address to make BT Connection
            deviceAddress = getIntent().getStringExtra("deviceAddress");
            // Show progree and connection status
            toolbar.setSubtitle("Connecting to " + deviceName + "...");
            progressBar.setVisibility(View.VISIBLE);
            buttonConnect.setEnabled(false);

            /*
            This is the most important piece of code. When "deviceName" is found
            the code will call a new thread to create a bluetooth connection to the
            selected device (see the thread code below)
             */
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            createConnectThread = new CreateConnectThread(bluetoothAdapter, deviceAddress);
            createConnectThread.start();
            createConnectThreadGround = new CreateConnectThreadGround(bluetoothAdapter, "00:22:12:01:2C:58");
            createConnectThreadGround.start();
            createConnectThreadSecond = new CreateConnectThreadSecond(bluetoothAdapter, "00:22:12:01:2C:4E");
            createConnectThreadSecond.start();
        }


        mHandler = new Handler();
        mRunnable = new Runnable() {

            @Override
            public void run() {
                IdleDialog idleDialog = new IdleDialog(MainActivity.this);
                idleDialog.show();
                Window window_idle = idleDialog.getWindow();
                window_idle.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            }
        };
        startHandler();

        /*
        Second most important piece of Code. GUI Handler
         */
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case CONNECTING_STATUS:
                        switch (msg.arg1) {
                            case 1:
                                toolbar.setSubtitle("Connected to " + deviceName);
                                progressBar.setVisibility(View.GONE);
                                buttonConnect.setEnabled(true);
                                connectedThread.write("19");
                                //initial_click = true;
                                loadMain();
                                break;
                            case -1:
                                toolbar.setSubtitle("Device fails to connect");
                                progressBar.setVisibility(View.GONE);
                                buttonConnect.setEnabled(true);
                                break;
                        }
                        break;
                }
            }
        };

        handlerGround = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case CONNECTING_STATUS:
                        switch (msg.arg1) {
                            case 1:
                                //connectedThreadGround.write("0N");
                                break;
                            case -1:
                                break;
                        }
                        break;
                }
            }
        };

        handlerSecond = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case CONNECTING_STATUS:
                        switch (msg.arg1) {
                            case 1:
                                //connectedThreadSecond.write("0N");
                                break;
                            case -1:
                                break;
                        }
                        break;
                }
            }
        };

        handlerAmenity = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case CONNECTING_STATUS:
                        switch (msg.arg1) {
                            case 1:
                                //connectedThreadAmenity.write("0N");
                                break;
                            case -1:
                                break;
                        }
                        break;
                }
            }
        };

        handlerTypical = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case CONNECTING_STATUS:
                        switch (msg.arg1) {
                            case 1:
                                //connectedThreadTypical.write("ON");
                                break;
                            case -1:
                                break;
                        }
                        break;
                }
            }
        };

        // Select Bluetooth Device
        buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Move to adapter list
                Intent intent = new Intent(MainActivity.this, SelectDeviceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onUserInteraction() {
        // TODO Auto-generated method stub
        super.onUserInteraction();
        stopHandler();//stop first and then start
        startHandler();
    }
    public void stopHandler() {
        mHandler.removeCallbacks(mRunnable);
    }
    public void startHandler() {
        //mHandler.postDelayed(mRunnable, 5*60*1000);
        mHandler.postDelayed(mRunnable, 5*60*1000);
    }

    public class IdleDialog extends Dialog implements
            android.view.View.OnClickListener {
        public Activity c;
        public IdleDialog(Activity a) {
            super(a);
            // TODO Auto-generated constructor stub
            this.c = a;
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.logo_idle);
        }

        @Override
        public void onClick(View v) {
            dismiss();
            stopHandler();//stop first and then start
            startHandler();
        }
        @Override
        public boolean dispatchTouchEvent(MotionEvent event)
        {
            this.dismiss();
            stopHandler();//stop first and then start
            startHandler();
            return false;
        }
    }

    public void setCmd(String val){
        /*if (initial_click){
            connectedThread.write("10");
            initial_click = false;
        }*/
        cmd = val;
        cmdText = cmd;
        connectedThread.write(cmdText);
    }

    public static String getScreenWidthAndHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        String w = String.valueOf(width);
        return w;
    }

    public String getAll_stat() {
        return all_stat;
    }

    public void setAll_stat(String all_stat) {
        this.all_stat = all_stat;
    }

    public String getAmenity_stat() {
        return amenity_stat;
    }

    public void setAmenity_stat(String amenity_stat) {
        this.amenity_stat = amenity_stat;
    }

    public String getAmenityPenthouse_stat() {
        return amenityPenthouse_stat;
    }

    public void setAmenityPenthouse_stat(String amenityPenthouse_stat) {
        this.amenityPenthouse_stat = amenityPenthouse_stat;
    }

    public String getAyalaSide_stat() {
        return ayalaSide_stat;
    }

    public void setAyalaSide_stat(String ayalaSide_stat) {
        this.ayalaSide_stat = ayalaSide_stat;
    }

    public String getDiscoveryPrimeaSide_stat() {
        return discoveryPrimeaSide_stat;
    }

    public void setDiscoveryPrimeaSide_stat(String discoveryPrimeaSide_stat) {
        this.discoveryPrimeaSide_stat = discoveryPrimeaSide_stat;
    }

    public String getGarden_stat() {
        return garden_stat;
    }

    public void setGarden_stat(String garden_stat) {
        this.garden_stat = garden_stat;
    }

    public String getBusinessCentre_stat() {
        return businessCentre_stat;
    }

    public void setBusinessCentre_stat(String businessCentre_stat) {
        this.businessCentre_stat = businessCentre_stat;
    }

    public String getFitnessCentre_stat() {
        return fitnessCentre_stat;
    }

    public void setFitnessCentre_stat(String fitnessCentre_stat) {
        this.fitnessCentre_stat = fitnessCentre_stat;
    }

    public String getAtriumLounge_stat() {
        return atriumLounge_stat;
    }

    public void setAtriumLounge_stat(String atriumLounge_stat) {
        this.atriumLounge_stat = atriumLounge_stat;
    }

    public String getArrivalLounge_stat() {
        return arrivalLounge_stat;
    }

    public void setArrivalLounge_stat(String arrivalLounge_stat) {
        this.arrivalLounge_stat = arrivalLounge_stat;
    }

    public String getRandom_stat() {
        return random_stat;
    }

    public void setRandom_stat(String random_stat) {
        this.random_stat = random_stat;
    }

    public String getLandscape_stat() {
        return landscape_stat;
    }

    public void setLandscape_stat(String landscape_stat) {
        this.landscape_stat = landscape_stat;
    }

    public String getLobby_stat() {
        return lobby_stat;
    }

    public void setLobby_stat(String lobby_stat) {
        this.lobby_stat = lobby_stat;
    }

    public String getSecondFloor_stat() {
        return secondFloor_stat;
    }

    public void setSecondFloor_stat(String secondFloor_stat) {
        this.secondFloor_stat = secondFloor_stat;
    }

    public String getTypicalFloor_stat() {
        return typicalFloor_stat;
    }

    public void setTypicalFloor_stat(String typicalFloor_stat) {
        this.typicalFloor_stat = typicalFloor_stat;
    }

    public String getRitzSide_stat() {
        return ritzSide_stat;
    }

    public void setRitzSide_stat(String ritzSide_stat) {
        this.ritzSide_stat = ritzSide_stat;
    }

    public String getUrdanetaSide_stat() {
        return urdanetaSide_stat;
    }

    public void setUrdanetaSide_stat(String urdanetaSide_stat) {
        this.urdanetaSide_stat = urdanetaSide_stat;
    }

    public String getPlayArea_stat() {
        return playArea_stat;
    }

    public void setPlayArea_stat(String playArea_stat) {
        this.playArea_stat = playArea_stat;
    }

    public String getWineTasting_stat() {
        return wineTasting_stat;
    }

    public void setWineTasting_stat(String wineTasting_stat) {
        this.wineTasting_stat = wineTasting_stat;
    }

    public String getOutdoorLounge_stat() {
        return outdoorLounge_stat;
    }

    public void setOutdoorLounge_stat(String outdoorLounge_stat) {
        this.outdoorLounge_stat = outdoorLounge_stat;
    }

    public String getWineCellar_stat() {
        return wineCellar_stat;
    }

    public void setWineCellar_stat(String wineCellar_stat) {
        this.wineCellar_stat = wineCellar_stat;
    }

    public String getPavillionLounge_stat() {
        return pavillionLounge_stat;
    }

    public void setPavillionLounge_stat(String pavillionLounge_stat) {
        this.pavillionLounge_stat = pavillionLounge_stat;
    }

    public String getPianoLounge_stat() {
        return pianoLounge_stat;
    }

    public void setPianoLounge_stat(String pianoLounge_stat) {
        this.pianoLounge_stat = pianoLounge_stat;
    }

    public String getPoolDeck_stat() {
        return poolDeck_stat;
    }

    public void setPoolDeck_stat(String poolDeck_stat) {
        this.poolDeck_stat = poolDeck_stat;
    }

    public String getStreet_stat() {
        return street_stat;
    }

    public void setStreet_stat(String street_stat) {
        this.street_stat = street_stat;
    }

    public void loadMain(){
        setContentView(R.layout.main_page);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_activity_main);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(navView, navController);
    }

    private void ALL_PERMISSION() {
        try {
            int PERMISSION_ALL = 1;
            String[] PERMISSIONS = {

                    android.Manifest.permission.BLUETOOTH,
                    android.Manifest.permission.BLUETOOTH_CONNECT,
                    android.Manifest.permission.BLUETOOTH_SCAN,
                    android.Manifest.permission.BLUETOOTH_ADMIN,
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
            };

            if (!hasPermissions(this, PERMISSIONS)) {
                ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
            }
        } catch (Exception ex) {
            Log.e(TAG, "ERROR: " + ex.getMessage());
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


    /* ============================ Thread to Create Bluetooth Connection =================================== */
    public static class CreateConnectThread extends Thread {

        public CreateConnectThread(BluetoothAdapter bluetoothAdapter, String address) {
            /*
            Use a temporary object that is later assigned to mmSocket
            because mmSocket is final.
             */
            BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
            BluetoothSocket tmp = null;
            UUID uuid = bluetoothDevice.getUuids()[0].getUuid();

            try {
                /*
                Get a BluetoothSocket to connect with the given BluetoothDevice.
                Due to Android device varieties,the method below may not work fo different devices.
                You should try using other methods i.e. :
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
                 */
                tmp = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid);

            } catch (IOException e) {
                Log.e(TAG, "Socket's create() method failed", e);
            }
            mmSocket = tmp;
        }

        public void run() {
            // Cancel discovery because it otherwise slows down the connection.
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAdapter.cancelDiscovery();
            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                mmSocket.connect();
                Log.e("Status", "Device connected");
                handler.obtainMessage(CONNECTING_STATUS, 1, -1).sendToTarget();
            } catch (IOException connectException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocket.close();
                    Log.e("Status", "Cannot connect to device");
                    handler.obtainMessage(CONNECTING_STATUS, -1, -1).sendToTarget();
                } catch (IOException closeException) {
                    Log.e(TAG, "Could not close the client socket", closeException);
                }
                return;
            }

            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.
            connectedThread = new ConnectedThread(mmSocket);
            connectedThread.run();
        }

        // Closes the client socket and causes the thread to finish.
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the client socket", e);
            }
        }
    }

    /* =============================== Thread for Data Transfer =========================================== */
    public static class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes = 0; // bytes returned from read()
            // Keep listening to the InputStream until an exception occurs
            while (true) {
                try {
                    /*
                    Read from the InputStream from Arduino until termination character is reached.
                    Then send the whole String message to GUI Handler.
                     */
                    buffer[bytes] = (byte) mmInStream.read();
                    String readMessage;
                    if (buffer[bytes] == '\n'){
                        readMessage = new String(buffer,0,bytes);
                        Log.e("Arduino Message",readMessage);
                        handler.obtainMessage(MESSAGE_READ,readMessage).sendToTarget();
                        bytes = 0;
                    } else {
                        bytes++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        /* Call this from the main activity to send data to the remote device */
        public void write(String input) {
            byte[] bytes = input.getBytes(); //converts entered String into bytes
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) {
                Log.e("Send Error","Unable to send message",e);
            }
        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) { }
        }
    }




    /* ============================ Thread to Create Bluetooth Connection =================================== */
    public static class CreateConnectThreadGround extends Thread {

        public CreateConnectThreadGround(BluetoothAdapter bluetoothAdapter, String address) {
            /*
            Use a temporary object that is later assigned to mmSocket
            because mmSocket is final.
             */
            BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
            BluetoothSocket tmp = null;
            UUID uuid = bluetoothDevice.getUuids()[0].getUuid();

            try {
                /*
                Get a BluetoothSocket to connect with the given BluetoothDevice.
                Due to Android device varieties,the method below may not work fo different devices.
                You should try using other methods i.e. :
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
                 */
                tmp = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid);

            } catch (IOException e) {
                Log.e(TAG, "Socket's create() method failed", e);
            }
            mmSocketGround = tmp;
        }

        public void run() {
            // Cancel discovery because it otherwise slows down the connection.
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAdapter.cancelDiscovery();
            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                mmSocketGround.connect();
                Log.e("Status", "Device connected");
                handlerGround.obtainMessage(CONNECTING_STATUS, 1, -1).sendToTarget();
            } catch (IOException connectException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocketGround.close();
                    Log.e("Status", "Cannot connect to device");
                    handlerGround.obtainMessage(CONNECTING_STATUS, -1, -1).sendToTarget();
                } catch (IOException closeException) {
                    Log.e(TAG, "Could not close the client socket", closeException);
                }
                return;
            }

            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.
            connectedThreadGround = new ConnectedThreadGround(mmSocketGround);
            connectedThreadGround.run();
        }

        // Closes the client socket and causes the thread to finish.
        public void cancel() {
            try {
                mmSocketGround.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the client socket", e);
            }
        }
    }

    /* =============================== Thread for Data Transfer =========================================== */
    public static class ConnectedThreadGround extends Thread {
        private final BluetoothSocket mmSocketGround;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThreadGround(BluetoothSocket socket) {
            mmSocketGround = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes = 0; // bytes returned from read()
            // Keep listening to the InputStream until an exception occurs
            while (true) {
                try {
                    /*
                    Read from the InputStream from Arduino until termination character is reached.
                    Then send the whole String message to GUI Handler.
                     */
                    buffer[bytes] = (byte) mmInStream.read();
                    String readMessage;
                    if (buffer[bytes] == '\n'){
                        readMessage = new String(buffer,0,bytes);
                        Log.e("Arduino Message",readMessage);
                        handlerGround.obtainMessage(MESSAGE_READ,readMessage).sendToTarget();
                        bytes = 0;
                    } else {
                        bytes++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        /* Call this from the main activity to send data to the remote device */
        public void write(String input) {
            byte[] bytes = input.getBytes(); //converts entered String into bytes
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) {
                Log.e("Send Error","Unable to send message",e);
            }
        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                mmSocketGround.close();
            } catch (IOException e) { }
        }
    }



    /* ============================ Thread to Create Bluetooth Connection =================================== */
    public static class CreateConnectThreadSecond extends Thread {

        public CreateConnectThreadSecond(BluetoothAdapter bluetoothAdapter, String address) {
            /*
            Use a temporary object that is later assigned to mmSocket
            because mmSocket is final.
             */
            BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
            BluetoothSocket tmp = null;
            UUID uuid = bluetoothDevice.getUuids()[0].getUuid();

            try {
                /*
                Get a BluetoothSocket to connect with the given BluetoothDevice.
                Due to Android device varieties,the method below may not work fo different devices.
                You should try using other methods i.e. :
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
                 */
                tmp = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid);

            } catch (IOException e) {
                Log.e(TAG, "Socket's create() method failed", e);
            }
            mmSocketSecond = tmp;
        }

        public void run() {
            // Cancel discovery because it otherwise slows down the connection.
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAdapter.cancelDiscovery();
            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                mmSocketSecond.connect();
                Log.e("Status", "Device connected");
                handlerSecond.obtainMessage(CONNECTING_STATUS, 1, -1).sendToTarget();
            } catch (IOException connectException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocketSecond.close();
                    Log.e("Status", "Cannot connect to device");
                    handlerSecond.obtainMessage(CONNECTING_STATUS, -1, -1).sendToTarget();
                } catch (IOException closeException) {
                    Log.e(TAG, "Could not close the client socket", closeException);
                }
                return;
            }

            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.
            connectedThreadSecond = new ConnectedThreadSecond(mmSocketSecond);
            connectedThreadSecond.run();
        }

        // Closes the client socket and causes the thread to finish.
        public void cancel() {
            try {
                mmSocketSecond.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the client socket", e);
            }
        }
    }

    /* =============================== Thread for Data Transfer =========================================== */
    public static class ConnectedThreadSecond extends Thread {
        private final BluetoothSocket mmSocketSecond;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThreadSecond(BluetoothSocket socket) {
            mmSocketSecond = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes = 0; // bytes returned from read()
            // Keep listening to the InputStream until an exception occurs
            while (true) {
                try {
                    /*
                    Read from the InputStream from Arduino until termination character is reached.
                    Then send the whole String message to GUI Handler.
                     */
                    buffer[bytes] = (byte) mmInStream.read();
                    String readMessage;
                    if (buffer[bytes] == '\n'){
                        readMessage = new String(buffer,0,bytes);
                        Log.e("Arduino Message",readMessage);
                        handlerSecond.obtainMessage(MESSAGE_READ,readMessage).sendToTarget();
                        bytes = 0;
                    } else {
                        bytes++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        /* Call this from the main activity to send data to the remote device */
        public void write(String input) {
            byte[] bytes = input.getBytes(); //converts entered String into bytes
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) {
                Log.e("Send Error","Unable to send message",e);
            }
        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                mmSocketSecond.close();
            } catch (IOException e) { }
        }
    }



    /* ============================ Thread to Create Bluetooth Connection =================================== */
    public static class CreateConnectThreadAmenity extends Thread {

        public CreateConnectThreadAmenity(BluetoothAdapter bluetoothAdapter, String address) {
            /*
            Use a temporary object that is later assigned to mmSocket
            because mmSocket is final.
             */
            BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
            BluetoothSocket tmp = null;
            UUID uuid = bluetoothDevice.getUuids()[0].getUuid();

            try {
                /*
                Get a BluetoothSocket to connect with the given BluetoothDevice.
                Due to Android device varieties,the method below may not work fo different devices.
                You should try using other methods i.e. :
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
                 */
                tmp = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid);

            } catch (IOException e) {
                Log.e(TAG, "Socket's create() method failed", e);
            }
            mmSocketAmenity = tmp;
        }

        public void run() {
            // Cancel discovery because it otherwise slows down the connection.
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAdapter.cancelDiscovery();
            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                mmSocketAmenity.connect();
                Log.e("Status", "Device connected");
                handlerAmenity.obtainMessage(CONNECTING_STATUS, 1, -1).sendToTarget();
            } catch (IOException connectException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocketAmenity.close();
                    Log.e("Status", "Cannot connect to device");
                    handlerAmenity.obtainMessage(CONNECTING_STATUS, -1, -1).sendToTarget();
                } catch (IOException closeException) {
                    Log.e(TAG, "Could not close the client socket", closeException);
                }
                return;
            }

            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.
            connectedThreadAmenity = new ConnectedThreadAmenity(mmSocketAmenity);
            connectedThreadAmenity.run();
        }

        // Closes the client socket and causes the thread to finish.
        public void cancel() {
            try {
                mmSocketAmenity.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the client socket", e);
            }
        }
    }

    /* =============================== Thread for Data Transfer =========================================== */
    public static class ConnectedThreadAmenity extends Thread {
        private final BluetoothSocket mmSocketAmenity;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThreadAmenity(BluetoothSocket socket) {
            mmSocketAmenity = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes = 0; // bytes returned from read()
            // Keep listening to the InputStream until an exception occurs
            while (true) {
                try {
                    /*
                    Read from the InputStream from Arduino until termination character is reached.
                    Then send the whole String message to GUI Handler.
                     */
                    buffer[bytes] = (byte) mmInStream.read();
                    String readMessage;
                    if (buffer[bytes] == '\n'){
                        readMessage = new String(buffer,0,bytes);
                        Log.e("Arduino Message",readMessage);
                        handlerAmenity.obtainMessage(MESSAGE_READ,readMessage).sendToTarget();
                        bytes = 0;
                    } else {
                        bytes++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        /* Call this from the main activity to send data to the remote device */
        public void write(String input) {
            byte[] bytes = input.getBytes(); //converts entered String into bytes
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) {
                Log.e("Send Error","Unable to send message",e);
            }
        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                mmSocketAmenity.close();
            } catch (IOException e) { }
        }
    }



    /* ============================ Thread to Create Bluetooth Connection =================================== */
    public static class CreateConnectThreadTypical extends Thread {

        public CreateConnectThreadTypical(BluetoothAdapter bluetoothAdapter, String address) {
            /*
            Use a temporary object that is later assigned to mmSocket
            because mmSocket is final.
             */
            BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
            BluetoothSocket tmp = null;
            UUID uuid = bluetoothDevice.getUuids()[0].getUuid();

            try {
                /*
                Get a BluetoothSocket to connect with the given BluetoothDevice.
                Due to Android device varieties,the method below may not work fo different devices.
                You should try using other methods i.e. :
                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
                 */
                tmp = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid);

            } catch (IOException e) {
                Log.e(TAG, "Socket's create() method failed", e);
            }
            mmSocketTypical = tmp;
        }

        public void run() {
            // Cancel discovery because it otherwise slows down the connection.
            BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            bluetoothAdapter.cancelDiscovery();
            try {
                // Connect to the remote device through the socket. This call blocks
                // until it succeeds or throws an exception.
                mmSocketTypical.connect();
                Log.e("Status", "Device connected");
                handlerTypical.obtainMessage(CONNECTING_STATUS, 1, -1).sendToTarget();
            } catch (IOException connectException) {
                // Unable to connect; close the socket and return.
                try {
                    mmSocketTypical.close();
                    Log.e("Status", "Cannot connect to device");
                    handlerTypical.obtainMessage(CONNECTING_STATUS, -1, -1).sendToTarget();
                } catch (IOException closeException) {
                    Log.e(TAG, "Could not close the client socket", closeException);
                }
                return;
            }

            // The connection attempt succeeded. Perform work associated with
            // the connection in a separate thread.
            connectedThreadTypical = new ConnectedThreadTypical(mmSocketTypical);
            connectedThreadTypical.run();
        }

        // Closes the client socket and causes the thread to finish.
        public void cancel() {
            try {
                mmSocketTypical.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the client socket", e);
            }
        }
    }

    /* =============================== Thread for Data Transfer =========================================== */
    public static class ConnectedThreadTypical extends Thread {
        private final BluetoothSocket mmSocketTypical;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThreadTypical(BluetoothSocket socket) {
            mmSocketTypical = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes = 0; // bytes returned from read()
            // Keep listening to the InputStream until an exception occurs
            while (true) {
                try {
                    /*
                    Read from the InputStream from Arduino until termination character is reached.
                    Then send the whole String message to GUI Handler.
                     */
                    buffer[bytes] = (byte) mmInStream.read();
                    String readMessage;
                    if (buffer[bytes] == '\n'){
                        readMessage = new String(buffer,0,bytes);
                        Log.e("Arduino Message",readMessage);
                        handlerTypical.obtainMessage(MESSAGE_READ,readMessage).sendToTarget();
                        bytes = 0;
                    } else {
                        bytes++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        /* Call this from the main activity to send data to the remote device */
        public void write(String input) {
            byte[] bytes = input.getBytes(); //converts entered String into bytes
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) {
                Log.e("Send Error","Unable to send message",e);
            }
        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                mmSocketTypical.close();
            } catch (IOException e) { }
        }
    }

    /* ============================ Terminate Connection at BackPress ====================== */
    @Override
    public void onBackPressed() {
        // Terminate Bluetooth Connection and close app
        if (createConnectThread != null){
            createConnectThread.cancel();
        }
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
