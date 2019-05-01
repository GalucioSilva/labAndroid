package com.soutosslave.listadepaises.Model;
import com.google.gson.annotations.SerializedName;


    public class Country {
        public String latitude;
        public String longitude;

        @SerializedName("name")
        public String name;

        @SerializedName("topLevelDomain")
        public String topLevelDomain[];

        @SerializedName("alpha2Code")
        public String alpha2Code;

        @SerializedName("alpha3Code")
        public String alpha3Code;

        @SerializedName("callingCodes")
        public String callingCodes[];

        @SerializedName("capital")
        public String capital;

        @SerializedName("altSpellings")
        public String altSpellings[];

        @SerializedName("region")
        public String region;

        @SerializedName("subregion")
        public String subregion;

        @SerializedName("population")
        public String population;

        @SerializedName("latlng")
        public String latlng[];

        @SerializedName("demonym")
        public String demonym;

        @SerializedName("area")
        public String area;

        @SerializedName("gini")
        public String gini;

        @SerializedName("timezones")
        public String timezones[];

        @SerializedName("borders")
        public String borders[];

        @SerializedName("nativeName")
        public String nativeName;

        @SerializedName("numericCode")
        public String numericCode;

        @SerializedName("currencies")
        public String currencies[];

        @SerializedName("languages")
        public String languages[];

        @SerializedName("relevance")
        public String relevance;

    public Country(String name, String alpha2Code, String alpha3Code, String capital, String region,
                   String subregion, String population, String area , String latlng[], String relevance) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.area = area;
        this.relevance = relevance;
        this.latitude = latlng[0];
        this.longitude = latlng[1];

    }


        @Override
        public String toString() {
            return "Country{" +
                    "name='" + name + '\'' +
                    ", lat=" + latlng[0] +
                    ", lon=" + latlng[1] +
                    '}';
        }

        public String[] getLatlng() {
            return latlng;
        }
    }