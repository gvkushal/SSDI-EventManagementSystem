import React, { useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import axios from "axios";
import { useHistory } from "react-router-dom";

const ViewEvent = () => {
    //const view_event_url = "http://localhost:3004/getevents";
    const [viewEvent, setViewEvent] = useState({
        eventId: "",
        eventName: "",
        description: "",
        eventStartTime: "",
        eventEndTime: "",
        location:""
      });
      const { id } = useParams();
      useEffect(() => {
        loadEvent();
      }, []);
      const loadEvent = async () => {
        //const res = await axios.get(`http://localhost:3004/getevents/${id}`);
        const res = await axios.get(`http://localhost:8080/event/{eventId}?eventId=${id}`);
        setViewEvent(res.data);
      };

      return (
        <div className="container">
          <Link className="btn btn-primary" to="/admin">
            back to Home
          </Link>
          <hr />
          <ul className="list-group">
            <li className="list-group-item active">Event id : {viewEvent.id}</li>
            <li className="list-group-item">Event Name: {viewEvent.eventName}</li>
            <li className="list-group-item">Description: {viewEvent.description}</li>
            <li className="list-group-item">Location: {viewEvent.location}</li>
            <li className="list-group-item">Start Date: {viewEvent.startTime}</li>
            <li className="list-group-item">End Date: {viewEvent.endTime}</li>
          </ul>
         
        </div>
        
      );
}

export default ViewEvent;
