package com.event.management.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



/*
{
	  "capactiy": 20,
	  "description": "boxing",
	  "endTime": "2021-12-01 13:30",
	  "eventName": "Boxing",
	  "location": "UNCC",
	  "remainingCapacity": 0,
	  "startTime": "2021-12-01 11:30"
	}*/


@Entity(name = "event")
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private int eventId;

	@Column(name = "event_name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

	/*
	 * @Column(name = "hosts") private String hosts;
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "event_start_time", nullable = false)
	private LocalDateTime startTime;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@Column(name = "event_end_time", nullable = false)
	private LocalDateTime endTime;

	@Column(name = "capacity", nullable = false)
	private int capacity;

	// @Column(name = "created_by", nullable = false)
	// private int createdBy;

	// @Column(name = "contact_email")
	// private String pointOfCotactEmail;

	@Column(name = "locaiton")
	private String location;

	// @ManyToOne(cascade = CascadeType.REMOVE)
	// @JoinColumn(name = "category")
	// private Category category;

	/*
	 * @Column(name = "category") private String category;
	 */

	@Column(name = "remaining_capacity", nullable = false)
	private int remainingCapacity;

	@JsonIgnore
	@Column(name = "created_on")
	@CreationTimestamp
	private LocalDateTime createdOn;

	@JsonIgnore
	@Column(name = "updated_on")
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
	 * Set<Registration> registrations = new HashSet<>();
	 */

	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE) Set<Comment>
	 * comments = new HashSet<>()
	 */;

	/*
	 * @Column(name = "registration_link") private String registrationLink;
	 */

	/*
	 * public void setRegistrations(Set<Registration> registrations) {
	 * this.registrations = registrations; }
	 */

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return name;
	}

	public void setEventName(String eventName) {
		this.name = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public String getHosts() { return hosts; }
	 * 
	 * public void setHosts(String hosts) { this.hosts = hosts; }
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capactiy) {
		this.capacity = capactiy;
	}

	/*
	 * public int getCreatedBy() { return createdBy; }
	 * 
	 * public void setCreatedBy(int createdBy) { this.createdBy = createdBy; }
	 * 
	 * public String getEventPointOfCotactEmail() { return pointOfCotactEmail; }
	 * 
	 * public void setEventPointOfCotactEmail(String eventPointOfCotactEmail) {
	 * this.pointOfCotactEmail = eventPointOfCotactEmail; }
	 */

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRemainingCapacity() {
		return remainingCapacity;
	}

	public void setRemainingCapacity(int remainingCapacity) {
		this.remainingCapacity = remainingCapacity;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	/*
	 * public void setCategory(Category category) { this.category = category; }
	 * 
	 * 
	 * public void setCategory(String category) { this.category = category; }
	 * 
	 * 
	 * 
	 * public void setComments(Set<Comment> comments) { this.comments =
	 * comments; }
	 * 
	 * 
	 * public String getRegistrationLink() { return registrationLink; }
	 * 
	 * public Category getCategory() { return category; }
	 * 
	 * public void setRegistrationLink(String registrationLink) {
	 * this.registrationLink = registrationLink; }
	 */

}
