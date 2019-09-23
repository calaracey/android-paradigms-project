import java.io.*;
class Weather extends prJSONfromURL{

        String name;
        String cloudDescription;
        double tempature;
        long humidity;
        long pressure;
        long visibility;
        double windSpeed;
        long sunset;
        long sunrise;

        

        //Constrcutor
        Weather(){
        }

        Weather(String name, double temp, String clouds, long humidity, long pressure, long visibility, double wind, long sunrise, long sunset){
            this.setName(name);
            this.setTemperature(temp);
            this.setClouds(clouds);
            this.setHumidity(humidity);
            this.setPressure(pressure);
            this.setVisibility(visibility);
            this.setWindSpeed(wind);
            this.setSunrise(sunrise);
            this.setSunset(sunset);
        }

        String getName(){
            return this.name;
        }

        void setName(String newName) {
            this.name = newName;
        }

        double getTempature() {
            return this.tempature;    
        }

        void setTemperature(double newTemp) {
            this.tempature = newTemp;
        }

        String getClouds() {
            return this.cloudDescription;    
        }

        void setClouds(String newClouds) {
            this.cloudDescription = newClouds;
        }

        long getHumidity() {
            return this.humidity;    
        }

        void setHumidity(long NewHumidity) {
            this.humidity = NewHumidity;
        }

        long getPressure() {
            return this.pressure;
        }

        void setPressure(long NewPressure){
            this.pressure = NewPressure;
        }
        
        long getVisibility() {
            return this.visibility;
        }

        void setVisibility(long NewVisibility){
            this.visibility = NewVisibility;
        }
        
        double getWindSpeed() {
            return this.windSpeed;
        }

        void setWindSpeed(double NewWindSpeed){
            this.windSpeed = NewWindSpeed;
        }

        long getSunset() {
            return this.sunset;
        }

        void setSunset(long NewSunset){
            this.sunset = NewSunset;
        }

        long getSunrise() {
            return this.sunrise;
        }

        void setSunrise(long NewSunrise){
            this.sunrise = NewSunrise;
        }
        @Override
        public String toString() {
            String str = "City Name: "+ getName() + "\nTemp: " + getTempature() + "\nWind: " + getWindSpeed() + "\nClouds:" + getClouds() + "\nVisibility: " + getVisibility() + "\nSunset Time: " + getSunset() + "\nSunrise Time: " + getSunrise() + "\nPressure:" + getPressure() + "\nHumidity:" + getHumidity();
            return str; 
        }

}
