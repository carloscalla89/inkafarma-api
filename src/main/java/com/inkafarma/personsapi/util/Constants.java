package com.inkafarma.personsapi.util;

public class Constants {

    public static final String MONGO_URI = "mongodb://belatrix:optimismo123@cluster0-shard-00-00-vtesx.gcp.mongodb.net:27017," +
            "cluster0-shard-00-01-vtesx.gcp.mongodb.net:27017," +
            "cluster0-shard-00-02-vtesx.gcp.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true";

    public static final int MONGO = 1;

    public static final String MONGO_DATABASE = "dbMoneyExchange";
    public static final String MONGO_EXCHANGE_COLLECTION = "ExchangeRateCollection";
    public static final String MONGO_USER_COLLECTION = "UserLoginCollection";
}
