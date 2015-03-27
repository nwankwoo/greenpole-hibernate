package org.greenpole.hibernate.entrypoint;
// Generated Mar 27, 2015 1:23:05 PM by Hibernate Tools 4.3.1



/**
 * DigitalCapture generated by hbm2java
 */
public class DigitalCapture  implements java.io.Serializable {


     private int id;
     private Holder holder;
     private byte[] signature;
     private byte[] fingerprint;

    public DigitalCapture() {
    }

    public DigitalCapture(Holder holder, byte[] signature, byte[] fingerprint) {
       this.holder = holder;
       this.signature = signature;
       this.fingerprint = fingerprint;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Holder getHolder() {
        return this.holder;
    }
    
    public void setHolder(Holder holder) {
        this.holder = holder;
    }
    public byte[] getSignature() {
        return this.signature;
    }
    
    public void setSignature(byte[] signature) {
        this.signature = signature;
    }
    public byte[] getFingerprint() {
        return this.fingerprint;
    }
    
    public void setFingerprint(byte[] fingerprint) {
        this.fingerprint = fingerprint;
    }




}


