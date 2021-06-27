package com.example.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {

    private String  mTemprature,micon,mcity,mWeatherType;
    int mCondition;

    public static weatherData fromJson(JSONObject jsonObject)
    {
        try {
            weatherData weatherD = new weatherData();
            weatherD.mcity = jsonObject.getString("name");
            weatherD.mCondition =  jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType  = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.micon  = updateWeatherICon(weatherD.mCondition);
            double tempResul = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue = (int) Math.rint(tempResul);
            weatherD.mTemprature = Integer.toString(roundedValue);

            return weatherD;
        } catch (JSONException e) {
            e.printStackTrace();

            return  null;
        }
    }

    private static String updateWeatherICon(int Condition) {
        if(Condition>=0 && Condition<=300)
        {
            return "thunderstorm1";
        }
        else if(Condition>=300 && Condition<=500)
        {
            return "lightrain";
        }
        else if(Condition>=500 && Condition<=600)
        {
            return "shower";
        }
        else if(Condition>=600 && Condition<=700)
        {
            return "snow2";
        }
        else if(Condition>=701 && Condition<=771)
        {
            return "fog";
        }
        else if(Condition>=772 && Condition<=800)
        {
            return "overcast";
        }
        else if(Condition==800)
        {
            return "sunny";
        }
        else if(Condition>=801 && Condition<=804)
        {
            return "cloudy";
        }
        else if(Condition>=900 && Condition<=902)
        {
            return "thunderstorm1";
        }
        else if(Condition==903)
        {
            return "snow1";
        }
        else if(Condition==904)
        {
            return "sunny";
        }
        else if(Condition>=905 && Condition<=1000)
        {
            return "thunderstorm2";
        }

        return "dunno";

    }

    public String getmTemprature() {
        return mTemprature+"°C";
    }

    public String getMicon() {
        return micon;
    }

    public String getMcity() {
        return mcity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }

    public int getmCondition() {
        return mCondition;
    }
}
