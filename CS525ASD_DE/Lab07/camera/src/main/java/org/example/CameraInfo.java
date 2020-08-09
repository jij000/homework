package org.example;

public class CameraInfo {
    String cameraId;
    String licensePlate;
    Long speed;

    public CameraInfo(String cameraId, String licensePlate, Long speed) {
        this.cameraId = cameraId;
        this.licensePlate = licensePlate;
        this.speed = speed;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }
}
