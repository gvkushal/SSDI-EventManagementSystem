package com.event.management.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

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

	@Column(name = "hosts")
	private String hosts;

	@Column(name = "event_start_time", nullable = true)
	private LocalDateTime startTime;

	@Column(name = "event_end_time", nullable = true)
	private LocalDateTime endTime;

	@Column(name = "capacity", nullable = false)
	private int capactiy;

	//@ApiModelProperty()
	@Column(name = "venue")
	private String venue;

	@Column(name = "venue_pincode")
	private int venuePincode;

	@Column(name = "created_by", nullable = false)
	private int createdBy;

	@Column(name = "contact_email")
	private String pointOfCotactEmail;

	@Column(name = "locaiton")
	private String location;

	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category", referencedColumnName = "id")*/
	private String category;

	@Column(name = "remaining_capacity", nullable = false)
	private int remainingCapacity;

	@Column(name = "created_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdOn;

	@Column(name = "updated_on", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime updatedOn;

	@JsonIgnore
	@OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
	Set<Registration> registrations = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
	Set<Comment> comments = new HashSet<>();

	@Column(name = "registration_link")
	private String registrationLink;
	
	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}

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

	public String getHosts() {
		return hosts;
	}

	public void setHosts(String hosts) {
		this.hosts = hosts;
	}

	public LocalDateTime getEventStartTime() {
		return startTime;
	}

	public void setEventStartTime(LocalDateTime eventStartTime) {
		this.startTime = eventStartTime;
	}

	public LocalDateTime getEventEndTime() {
		return endTime;
	}

	public void setEventEndTime(LocalDateTime eventEndTime) {
		this.endTime = eventEndTime;
	}

	public int getCapactiy() {
		return capactiy;
	}

	public void setCapactiy(int capactiy) {
		this.capactiy = capactiy;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getVenuePincode() {
		return venuePincode;
	}

	public void setVenuePincode(int venuePincode) {
		this.venuePincode = venuePincode;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getEventPointOfCotactEmail() {
		return pointOfCotactEmail;
	}

	public void setEventPointOfCotactEmail(String eventPointOfCotactEmail) {
		this.pointOfCotactEmail = eventPointOfCotactEmail;
	}

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

	public void setCategory(String category) {
		this.category = category;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public String getRegistrationLink() {
		return registrationLink;
	}

	public void setRegistrationLink(String registrationLink) {
		this.registrationLink = registrationLink;
	}

}
