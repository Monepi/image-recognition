module com.greetings {
    requires unirest.java;
    requires httpcore;
    requires spring.core;
    requires spring.beans;
    uses com.mashape.unirest.http.HttpResponse;
    uses com.mashape.unirest.http.Unirest;
    uses org.apache.http.HttpHost;
}