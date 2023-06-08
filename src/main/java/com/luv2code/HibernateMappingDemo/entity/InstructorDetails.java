package com.luv2code.HibernateMappingDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail") //always be mindful of the table annotation otherwise !LOL
public class InstructorDetails {
    //annotate the class as an entity and map db table
    //define the fields
    //annotate the fields with db column names
    // create constructor
    // create the getters and setters
    //generate toString method
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="youtube_channel")
    private String youtubeChannel;
    @Column(name = "hobby")
    private String hobby;

    //default constructor as required

    //add @OneToOne Annotation to achieve a two-way by-directional relationship
    //between instructor and instructorDetail class
    //cascade type all performs the same operation on the corresponding table
    //only use when you want the action performed in one entity to be reflected in the related entity

    @OneToOne(mappedBy = "instructorDetails",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;
    public InstructorDetails(){}
    public InstructorDetails(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
