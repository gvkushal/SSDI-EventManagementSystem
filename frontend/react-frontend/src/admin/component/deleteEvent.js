import React, { useState,useEffect } from "react";
import axios from 'axios';
import { useHistory, useParams,Link } from "react-router-dom";

const DeleteEvent = () => {
   // const update_event_post_url = `http://localhost:3004/getevents/${id}`;
    let history = useHistory();
    const {id} = useParams();
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
        axios.delete(`http://localhost:8080/event/delete/=${id}`).then(res => {
            if (res.status = 200) {
                history.push("/admin");
            }
        });


    }
    useEffect(() => {
        loadEvent();
    }, [])
const loadEvent = async () =>{
 const result = await axios.get(`http://localhost:8080/event/{eventId}?eventId=${id}`);
 setevntDta(result.data);
}
    return (
        <div className="container">
             <div className="w-75 mx-auto shadow p-5">
            <h3>Delete Event for {evntDta.eventId}</h3>
            <Link className="btn btn-primary" to="/admin">
            back to Home
            </Link>
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
                <input type="text" className="form-control" name="eventStartTime" value={evntDta.startTime} onChange={handleChange} />
            </div>

            <div className="form-group">
                <label>End Date</label>
                <input type="text" className="form-control" name="eventEndTime" value={evntDta.endTime} onChange={handleChange} />
            </div>
            <button type="submit" className="btn btn-danger btn-block" onClick={handleSubmit} >
                Delete Event
            </button>
        
        </div>
        </div>
    );
}

export default DeleteEvent;
