package org.example;

public class StolenCarHandler extends Handler {
    public StolenCarHandler(Handler nextHandler) {
        super(nextHandler);
    }
    @Override
    public void handle(CameraInfo cameraInfo) {
        if (cameraInfo.getLicensePlate().matches( "Stolen.*")) {
            System.out.println("notify the police for Stolen Car: " + cameraInfo.getLicensePlate());
        }
        if (nextHandler != null) {
            nextHandler.handle(cameraInfo);
        }
    }
}
