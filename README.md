*Please be aware that this application / sample is provided as-is for demonstration purposes without any guarantee of support*
=========================================================

# Detect PTT Keys via Android Intents on Zebra Devices Demo
Demo app to show the Zebra RemoteKey Service to deliver PTT keys via Intents

**This sample application is designed to compliment the official sample app at http://zebra-stage.github.io/emdk-for-android/7-6/samples/usingptt/**

In Android system only foreground will be able to receive the events generated by the input devices such as Keyboards, GPIO Keys, Touch etc. (there are exceptions like HOME, BACK etc.) Some of the enterprise features\applications that are shipped (or Sideloaded) with the Zebra devices requires certain key events to be notified even when they are running in the background. Remote Key Event Service (RKES) is a legacy service that facilitates the above-mentioned requirements in Zebra devices. This service uses intents to notify the occurrence of four preconfigured key events (can not be changed)

The remote key intents will be having below format:
- Intent Action: specifies the key event that generated the intent
- Intent extras:
  - Intent.EXTRA_KEY_EVENT: The actual key event object ([details on key event objects](https://developer.android.com/reference/android/view/KeyEvent)).
The event object is generated from remote key service using following data:
    - Key Code
    - Action: 0 means key down, and 1 means key up
    - Down time
    - Time of event
    - Repeat count

Following section briefly describes about each intent that are broadcasted by the remote key event service. The above-mentioned intent format applies to all the intents broadcasted by the remote key service.

1. com.symbol.button.L1
This intent will be broadcasted by the service on occurrence of a key event corresponding to the key code KEYCODE_BUTTON_L1 (102).

2. com.symbol.button.L2
This intent will be broadcasted by the service on occurrence of a key event corresponding to the key code KEYCODE_BUTTON_L2 (104). This keycode is used for Push To Talk.

3. com.symbol.button.R1
This intent will be broadcasted by the service on occurrence of a key event corresponding to the key code KEYCODE_BUTTON_R1 (103).  

4. com.symbol.button.R2
This intent will be broadcasted by the service on occurrence of a key event corresponding to the key code KEYCODE_BUTTON_R2 (105).  This keycode is used for headset button (during Push To Talk session).

![Screenshot 1](https://raw.githubusercontent.com/darryncampbell/EMDK-PTTKeys-Demo/master/screenshots/1.jpg)
![Screenshot 2](https://raw.githubusercontent.com/darryncampbell/EMDK-PTTKeys-Demo/master/screenshots/2.jpg)
![Screenshot 3](https://raw.githubusercontent.com/darryncampbell/EMDK-PTTKeys-Demo/master/screenshots/3.jpg)
