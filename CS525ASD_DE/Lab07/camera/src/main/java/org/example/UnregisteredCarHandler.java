package org.example;

public class UnregisteredCarHandler extends Handler {
    public UnregisteredCarHandler(Handler nextHandler) {
        super(nextHandler);
    }
    @Override
    public void handle(CameraInfo cameraInfo) {
        if (cameraInfo.getLicensePlate().matches( "Unregistered.*")) {
            System.out.println("send the owner a Unregistered car ticket: " + cameraInfo.getLicensePlate());
        }
        if (nextHandler != null) {
            nextHandler.handle(cameraInfo);
        }
    }
}
