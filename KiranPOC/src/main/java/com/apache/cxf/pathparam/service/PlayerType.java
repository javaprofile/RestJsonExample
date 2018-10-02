package com.apache.cxf.pathparam.service;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "playerId",
    "name",
    "age",
    "matches"
})
@XmlRootElement(name = "PlayerType")
public class PlayerType {
 
    protected int playerId;
    @XmlElement(required = true)
    protected String name;
    protected int age;
    protected int matches;
 
    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int value) {
        this.playerId = value;
    }
    public String getName() {
        return name;
    }
    public void setName(String value) {
        this.name = value;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int value) {
        this.age = value;
    }
    public int getMatches() {
        return matches;
    }
    public void setMatches(int value) {
        this.matches = value;
    }
}
