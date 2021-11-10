import React, { useState } from "react";
import axios from 'axios';
import { useHistory,Link } from "react-router-dom";

const CreateEvent = () => {
    const create_post_url = 'http://localhost:3004/getevents';
    let history = useHistory();
    const [evntDta, setevntDta] = useState({
        eventId: "",
        eventName: "",
        description: "",
        eventStartTime: "",
        eventEndTime: "",
        location: ""

    });
    const handleChange = (event) => {
        setevntDta({
            ...evntDta,
            [event.target.name]: event.target.value,

        });
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        axios.post(create_post_url, {
            eventId: evntDta.eventId,
            eventName: evntDta.eventName,
            description: evntDta.description,
            eventStartTime: evntDta.eventStartTime,
            eventEndTime: evntDta.eventEndTime,
            location: evntDta.location
        }).then(res => {
            if (res.status = 200) {
                history.push("/admin");
            }
        });


    }

    return (
        <div className="container">
        <form>
            <h3>Create Event</h3>
            <Link className="btn btn-info" to="/admin">
            Go Back
            </Link>
            <div className="form-group">
                <label>Event ID</label>
                <input type="text" className="form-control" name="eventId" value={evntDta.eventId} onChange={handleChange} />
            </div>

            <div className="form-group">
                <label>Event Title</label>
                <input type="text" className="form-control" name="eventName" value={evntDta.eventName} onChange={handleChange} />
            </div>

            <div className="form-group">
                <label>Description</label>
                <input type="email" className="form-control" name="description" value={evntDta.description} onChange={handleChange} />
            </div>

            <div className="form-group">
                <label>Location</label>
                <input type="text" className="form-control" name="location" value={evntDta.location} onChange={handleChange} />
            </div>

            <div className="form-group">
                <label>Start Date</label>
                <input type="text" className="form-control" name="eventStartTime" value={evntDta.eventStartTime} onChange={handleChange} />
            </div>

            <div className="form-group">
                <label>End Date</label>
                <input type="text" className="form-control" name="eventEndTime" value={evntDta.eventEndTime} onChange={handleChange} />
            </div>
            <button type="submit" className="btn btn-primary btn-block" onClick={handleSubmit} >
                Create Event
            </button>
        </form>
        </div>
    );
}
export default CreateEvent;
