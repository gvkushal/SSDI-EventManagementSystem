import React, { useState, useEffect } from "react";
import axios from 'axios';
import { Link, useHistory } from "react-router-dom";

const Admin = () => {
    const get_all_events_url = 'http://localhost:8080/event/all';
    const [events, setEvents] = useState([]);


    useEffect(() => {
        loadAllEvents();
    }, []);


    const loadAllEvents = async () => {
        const response = await axios.get(get_all_events_url);
        //console.log(response.data);
        setEvents(response.data);
    }
    const deleteEvent = async id => {
        await axios.delete(`http://localhost:3004/getevents/${id}`);
        loadAllEvents();
      };
    return (
        <div className="container">
      <Link className="btn btn-primary" to="/admin/create-event">Create Event</Link>
      <Link className="btn btn-info" to="/Dashboard">Dashboard</Link>
                <table class="table border">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Event ID</th>
                            <th scope="col">Title</th>
                            <th scope="col">Description</th>
                            <th scope="col">Location</th>
                            <th scope="col">Start Date</th>
                            <th scope="col">End Date</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            events.map((evnt, index) => (
                                <tr>
                                    <th scope="row">{evnt.eventId}</th>
                                    <td>{evnt.eventName}</td>
                                    <td>{evnt.description}</td>
                                    <td>{evnt.location}</td>
                                    <td>{evnt.startTime}</td>
                                    <td>{evnt.endTime}</td>
                                    <td>
                                        <Link className="btn btn-primary btn-sm" to={`/admin/view-event/${evnt.eventId}`}>View</Link>
                                        <Link className="btn btn-outline-primary btn-sm" to={`/admin/update-event/${evnt.eventId}`}>Edit</Link>
                                        <Link className="btn btn-danger btn-sm" to={`/admin/delete-event/${evnt.eventId}`}>Delete</Link>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
                </div>
    );
}
export default Admin;