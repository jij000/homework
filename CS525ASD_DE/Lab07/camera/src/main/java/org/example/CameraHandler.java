package org.example;

public class CameraHandler {
    private Handler chainOfHandlers;
    public void setChainOfHandlers(Handler chainOfHandlers) {
        this.chainOfHandlers = chainOfHandlers;
    }
    public void handleCameraInfo(CameraInfo cameraInfo) {
        chainOfHandlers.handle(cameraInfo);
    }
}
