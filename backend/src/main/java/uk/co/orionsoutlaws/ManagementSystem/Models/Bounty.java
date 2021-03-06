package uk.co.orionsoutlaws.ManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bounties")
public class Bounty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "target_name")
    private String targetName;

    @Column
    private int reward;

    @Column
    private boolean completed;

    @Column(name = "last_known_lat")
    private double lastKnownLat;

    @Column(name = "last_known_long")
    private double lastKnownLong;

    @Column(name = "image_path")
    private String imagePath;

    @JsonIgnoreProperties("bounties")
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "bounty")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Assignment> assignments;

    public Bounty(String targetName, int reward, double lastKnownLat, double lastKnownLong, String imagePath, Customer customer) {
        this.targetName = targetName;
        this.reward = reward;
        this.completed = false;
        this.lastKnownLat = lastKnownLat;
        this.lastKnownLong = lastKnownLong;
        this.imagePath = imagePath;
        this.customer = customer;
        assignments = new ArrayList<>();
    }

    public Bounty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public double getLastKnownLat() {
        return lastKnownLat;
    }

    public void setLastKnownLat(double lastKnownLat) {
        this.lastKnownLat = lastKnownLat;
    }

    public double getLastKnownLong() {
        return lastKnownLong;
    }

    public void setLastKnownLong(double lastKnownLong) {
        this.lastKnownLong = lastKnownLong;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }


    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<Double> getLastKnownLocation() {
        ArrayList<Double> coords = new ArrayList<>();
        coords.add(getLastKnownLat());
        coords.add(getLastKnownLong());
        return coords;
    }
}
