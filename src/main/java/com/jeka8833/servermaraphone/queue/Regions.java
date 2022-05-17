package com.jeka8833.servermaraphone.queue;

public enum Regions {
    KYIV("Київська"),
    VOLYN("Волинська"),
    DNIPROPETROVSK("Дніпропетровська"),
    DONETSK("Донецька"),
    ZHYTOMYR("Житомирська"),
    ZAPORIZHZHIA("Запорізька"),
    LUHANSK("Луганська"),
    MYKOLAIV("Миколаївська"),
    ODESA("Одеська"),
    SUMY("Сумська"),
    KHARKIV("Харківська"),
    KHERSON("Херсонська"),
    CHERNIHIV("Чернігівська");

    public final String name;

    Regions(String name) {
        this.name = name;
    }

    public String getRealName() {
        return name;
    }
}
