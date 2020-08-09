package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CameraHandler cameraHandler = new CameraHandler();
        StolenCarHandler stolenCarHandler = new StolenCarHandler(null);
        SpeedingCarHandler speedingCarHandler = new SpeedingCarHandler(stolenCarHandler);
        UnregisteredCarHandler unregisteredCarHandler = new UnregisteredCarHandler(speedingCarHandler);
        UnpaidTicketsHandler unpaidTicketsHandler = new UnpaidTicketsHandler(unregisteredCarHandler);

        cameraHandler.setChainOfHandlers(unpaidTicketsHandler);
        cameraHandler.handleCameraInfo(new CameraInfo("camera01", "Unregistered", 55L));
        cameraHandler.handleCameraInfo(new CameraInfo("camera02", "normal", 80L));
        cameraHandler.handleCameraInfo(new CameraInfo("camera03", "Stolen", 55L));
        cameraHandler.handleCameraInfo(new CameraInfo("camera04", "unpaid123", 55L));
        cameraHandler.handleCameraInfo(new CameraInfo("camera05", "unpaid456", 95L));
    }
}
