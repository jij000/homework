package org.example;

public class SpeedingCarHandler extends Handler {
    public SpeedingCarHandler(Handler nextHandler) {
        super(nextHandler);
    }
    @Override
    public void handle(CameraInfo cameraInfo) {
        if (cameraInfo.getSpeed() > 65L) {
            System.out.println("send the owner a speeding ticket: " + cameraInfo.getLicensePlate());
        }
        if (nextHandler != null) {
            nextHandler.handle(cameraInfo);
        }
    }
}
