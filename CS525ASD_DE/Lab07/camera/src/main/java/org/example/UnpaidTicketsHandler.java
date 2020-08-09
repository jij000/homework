package org.example;

public class UnpaidTicketsHandler extends Handler {
    public UnpaidTicketsHandler(Handler nextHandler) {
        super(nextHandler);
    }
    @Override
    public void handle(CameraInfo cameraInfo) {
        if (cameraInfo.getLicensePlate().matches( "unpaid.*")) {
            System.out.println("notify the police for unpaid tickets: " + cameraInfo.getLicensePlate());
        }
        if (nextHandler != null) {
            nextHandler.handle(cameraInfo);
        }
    }
}
