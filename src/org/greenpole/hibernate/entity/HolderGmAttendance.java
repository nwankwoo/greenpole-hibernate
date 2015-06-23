package org.greenpole.hibernate.entity;
// Generated 23-Jun-2015 04:56:55 by Hibernate Tools 4.3.1



/**
 * HolderGmAttendance generated by hbm2java
 */
public class HolderGmAttendance  implements java.io.Serializable {


     private HolderGmAttendanceId id;
     private Long version;
     private Gm gm;
     private Holder holder;
     private String proxy;

    public HolderGmAttendance() {
    }

	
    public HolderGmAttendance(HolderGmAttendanceId id, Gm gm, Holder holder) {
        this.id = id;
        this.gm = gm;
        this.holder = holder;
    }
    public HolderGmAttendance(HolderGmAttendanceId id, Gm gm, Holder holder, String proxy) {
       this.id = id;
       this.gm = gm;
       this.holder = holder;
       this.proxy = proxy;
    }
   
    public HolderGmAttendanceId getId() {
        return this.id;
    }
    
    public void setId(HolderGmAttendanceId id) {
        this.id = id;
    }
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    public Gm getGm() {
        return this.gm;
    }
    
    public void setGm(Gm gm) {
        this.gm = gm;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public String getProxy() {
        return this.proxy;
    }
    
    public void setProxy(String proxy) {
        this.proxy = proxy;
    }




}


