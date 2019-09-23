#import <"string.h>

class Weather extends prJSONfromURL{

        String name;
        String cloudDescription;
        Double tempature;
        int humidity;
        int pressure;
        int visibility;
        float windSpeed;
        long sunset;
        long sunrise;

        

        //Constrcutor
        Weather(){
        }

        Weather(String name, Double temp, String clouds, int humidity, int pressure, int visibility, float wind, long sunrise, long sunset){
            this.setName(name);
            this.setTempature(temp);
            this.setClouds(clouds);
            this.setHumidity(humidity);
            this.setPressure(pressure);
            this.setVisibility(visibility);
            this.setWindSpeed(wind);
            this.setSunriseTime(sunrise);
            this.setSunsetTime(sunset);
        }

        String getName(){
            return this.name;
        }

        void setName(String newName) {
            this.name = newName;
        }

        Double getTempature() {
            return this.tempature;    
        }

        void setTempature(Double newTemp) {
            this.tempature = newTemp;
        }

        String getClouds() {
            return this.cloudDescription;    
        }

        void setClouds(String newClouds); {
            this.cloudDescription = NewClouds;
        }

        int getHumidity() {
            return this.humidity;    
        }

        void setHumidity(int NewHumidity) {
            this.humidity = NewHumidity;
        }

        int getPressure() {
            return this.pressure;
        }

        void setPressure(String NewPressure){
            this.pressure = NewPressure;
        }
        
        int getGenre() {
            return this.visibility;
        }

        void setVisibility(String NewVisibility){
            this.visibility = NewVisibility;
        }
        
        float getWindSpeed() {
            return this.windSpeed;
        }

        void setWindSpeed(float NewWindSpeed){
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
