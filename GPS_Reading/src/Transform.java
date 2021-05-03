/**
 * Transform value of latitude and longitude into degree
 *
 * @author 0086C047 潘俊言
 * @version 1.0
 */

public class Transform {
    private String latitude, longitude;

    /**
     * constructor
     */
    public Transform(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        latitudeTrans();
        longitudeTrans();
    }

    /**
     * latitude transform method
     */
    public void latitudeTrans() {
        double degree = Double.parseDouble(latitude.substring(0, 2));
        double minute = Double.parseDouble(latitude.substring(2, 9));
        minute /= 60;
        latitude = String.valueOf(degree + minute);
    }

    /**
     * longitude transform method
     */
    public void longitudeTrans() {
        double degree = Double.parseDouble(longitude.substring(0, 3));
        double minute = Double.parseDouble(longitude.substring(3, 10));
        minute /= 60;
        longitude = String.valueOf(degree + minute);
    }

    /**
     * @return latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @return longitude
     */
    public String getLongitude() {
        return longitude;
    }
}

