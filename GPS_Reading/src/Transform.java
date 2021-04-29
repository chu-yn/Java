/**
 * @author 0086C047 潘俊言
 * @version 1.0
 */

public class Transform {
    public static String latitudeTrans(String latitude) {
        double degree = Double.parseDouble(latitude.substring(0, 2));
        double minute = Double.parseDouble(latitude.substring(2, 9));
        minute /= 60;
        latitude = String.valueOf(degree + minute);
        return latitude;
    }

    public static String longitudeTrans(String longitude){
        double degree = Double.parseDouble(longitude.substring(0, 3));
        double minute = Double.parseDouble(longitude.substring(3, 10));
        minute /= 60;
        longitude = String.valueOf(degree + minute);
        return longitude;
    }


}
