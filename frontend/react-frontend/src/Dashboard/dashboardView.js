import React, { useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import axios from "axios";
import { useHistory } from "react-router-dom";

const DashboardView = () => {
    //const view_event_url = "http://localhost:3004/getevents";
    const [dashboardView, setDashboardView] = useState({
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
        const res = await axios.get(`http://localhost:3004/getevents/${id}`);
        setDashboardView(res.data);
      };

      return (
        <div className="container">
          <Link className="btn btn-primary" to="/Dashboard">
            back to Home
          </Link>
          <hr />
          <ul className="list-group">
            <li className="list-group-item active">Event id : {dashboardView.id}</li>
            <li className="list-group-item">Event Name: {dashboardView.eventName}</li>
            <li className="list-group-item">Description: {dashboardView.description}</li>
            <li className="list-group-item">Location: {dashboardView.location}</li>
            <li className="list-group-item">Start Date: {dashboardView.eventStartTime}</li>
            <li className="list-group-item">End Date: {dashboardView.eventEndTime}</li>
          </ul>
         
        </div>
        
      );
}

export default DashboardView;
