package gov.ncbi.maloneyc.weather.model;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * The model for the simple form
 */

public class Weather {

    private String city;
    private String img;
    private boolean isSubmit;
    public String message;
    private String region;
    private String temp;
    private List<YweatherForecast> yWF_list;

    @Digits(integer = 5, fraction = 0, message = "Zip Code must be numeric and should consist exactly 5 digits")
    @NotNull(message = "Enter Zip code, it can't be null!")
    private Integer zipcode;



    public String getCity() {
        return city;
    }

    public String getImg() {
        return img;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRegion() {
        return region;
    }

    public String getTemp() {
        return temp;
    }

    public List<YweatherForecast> getyWF_list() {
        return yWF_list;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public boolean isSubmit() {
        return isSubmit;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSubmit(boolean isSubmit) {
        this.isSubmit = isSubmit;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setyWF_list(List<YweatherForecast> yWF_list) {
        this.yWF_list = yWF_list;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Weather for zipcode " + zipcode;
    }
}
