package ru.pes.Objects;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pc")
public class PC implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    
    @Column(name = "INV")
    private String inventory;
    
    @Column(name = "LOCATION")
    private String location;

    @Column(name = "DEPARTMENT")
    private String department;
    
    @Column(name = "PC_NAME")
    private String name;
    
    @Column(name = "MB_VENDOR")
    private String mb_vendor;
    
    @Column(name = "MB_NAME")
    private String mb_name;
    
    @Column(name = "CPU_VENDOR")
    private String vendor;
    
    @Column(name = "CPU_MODEL")
    private String model;
    
    @Column(name = "CPU_CORES")
    private String cores;
    
    @Column(name = "CPU_MHZ")
    private String mhz;
    
    @Column(name = "IP_ADDR")
    private String ipaddr;
    
    @Column(name = "MAC_ADDR")
    private String macaddr;
    
    @Column(name = "OS_NAME")
    private String osname;
    
    @Column(name = "OS_ARCH")
    private String osarch;
    
    @Column(name = "RAM_TOTAL")
    private long ram;
    
    @Column(name = "HDD")
    private String hdd;
    
    public PC(){}
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @param vendor the vendor to set
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the cores
     */
    public String getCores() {
        return cores;
    }

    /**
     * @param cores the cores to set
     */
    public void setCores(String cores) {
        this.cores = cores;
    }

    /**
     * @return the mhz
     */
    public String getMhz() {
        return mhz;
    }

    /**
     * @param mhz the mhz to set
     */
    public void setMhz(String mhz) {
        this.mhz = mhz;
    }

    /**
     * @return the ipaddr
     */
    public String getIpaddr() {
        return ipaddr;
    }

    /**
     * @param ipaddr the ipaddr to set
     */
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    /**
     * @return the macaddr
     */
    public String getMacaddr() {
        return macaddr;
    }

    /**
     * @param macaddr the macaddr to set
     */
    public void setMacaddr(String macaddr) {
        this.macaddr = macaddr;
    }

    /**
     * @return the osname
     */
    public String getOsname() {
        return osname;
    }

    /**
     * @param osname the osname to set
     */
    public void setOsname(String osname) {
        this.osname = osname;
    }

    /**
     * @return the osarch
     */
    public String getOsarch() {
        return osarch;
    }

    /**
     * @param osarch the osarch to set
     */
    public void setOsarch(String osarch) {
        this.osarch = osarch;
    }

    /**
     * @return the ram
     */
    public long getRam() {
        return ram;
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(long ram) {
        this.ram = ram;
    }

    /**
     * @return the hdd
     */
    public String getHdd() {
        return hdd;
    }

    /**
     * @param hdd the hdd to set
     */
    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    /**
     * @return the inventory
     */
    public String getInventory() {
        return inventory;
    }

    /**
     * @param inventory the inventory to set
     */
    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    /**
     * @return the mb_vendor
     */
    public String getMb_vendor() {
        return mb_vendor;
    }

    /**
     * @param mb_vendor the mb_vendor to set
     */
    public void setMb_vendor(String mb_vendor) {
        this.mb_vendor = mb_vendor;
    }

    /**
     * @return the mb_name
     */
    public String getMb_name() {
        return mb_name;
    }

    /**
     * @param mb_name the mb_name to set
     */
    public void setMb_name(String mb_name) {
        this.mb_name = mb_name;
    }
}
