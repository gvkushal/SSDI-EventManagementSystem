import React, { useState, useEffect } from "react";
import axios from 'axios';
import { Link, useHistory, useParams} from "react-router-dom";
import Navbar from '../nav/navbar';

const Dashboard = () => {
    
  const get_all_events_url = 'http://localhost:8080/event/all';
  const get_user_rsvp = 'http://localhost:3004/evntRsvp/';
  const [events, setEvents] = useState([]);
  const [eventsRsvp, setEventsRsvp] = useState([]);


    useEffect(() => {
        loadAllEvents();
        checkrsvp();
    }, []);

const checkrsvp = async () =>{
    const response = await axios.get(get_user_rsvp);
    console.log(" das " +response.data.evntRsvpSub);
    setEventsRsvp(response.data);
}
    const loadAllEvents = async () => {
        const response = await axios.get(get_all_events_url);
        //console.log(response.data);
        setEvents(response.data);
    }

    const Rsvp = () => {
      // const update_event_post_url = `http://localhost:3004/getevents/${id}`;
      const rsvp_url='http://localhost:3004/getevents/${id}`';

       let history = useHistory();
       
       const handleRsvp = (event) => {
           event.preventDefault();
           axios.post( rsvp_url)
            
          .then(res=> {
            history.push("/Rsvp");
       });

       }
    
  }
    return (
      <>
      <Navbar/>
        <div className="container">
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
                                    <th scope="row">{index + 1}</th>
                                    <td>{evnt.eventName}</td>
                                    <td>{evnt.description}</td>
                                    <td>{evnt.location}</td>
                                    <td>{evnt.startTime}</td>
                                    <td>{evnt.endTime}</td>
                                    <td>
                                        <Link className="btn btn-primary btn-sm" to={`/Dashboard/dashboardView/${evnt.eventId}`}>View</Link>
                                      {
                                         eventsRsvp.evntRsvpSub=='y' && eventsRsvp.evntID === evnt.id?  <Link className="btn btn-outline-primary btn-sm" to={`/admin/rsvp/${evnt.id}`}>Subscribed</Link> :  <Link className="btn btn-outline-danger btn-sm" to={`/admin/rsvp/${evnt.id}`}>RSVP</Link> 
                                      }
                                      
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
                </div>
      </>
    );
}

export default Dashboard;