package com.jeka8833.servermaraphone.queue;

public class Request {
    private final long id;
    private final String phoneNumber;
    private final Regions region;

    private final String pvo;

    private ProcessStatus status;

    private String managerName;

    public Request(long id, String phoneNumber, Regions region, String pvo, ProcessStatus status) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.pvo = pvo;
        this.status = status;
    }

    public String getPvo() {
        return pvo;
    }

    public ProcessStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Regions getRegion() {
        return region;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        return pvo != null ? pvo.equals(request.pvo) : request.pvo == null;
    }

    @Override
    public int hashCode() {
        return pvo != null ? pvo.hashCode() : 0;
    }
}
