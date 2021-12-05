import React, { Component, useState } from "react";
import axios from 'axios';

import { useHistory, useParams,Link } from "react-router-dom";

import '../../../src/screen.css';



const Rsvp = () =>{
  let history = useHistory();
  const {id} = useParams();

  const [rsvp, setRsvp] = useState({
    yesChoice: "",
    noChoice: ""
  });

  const handleChange = (event) => {
    console.log(event.target.value);
    setRsvp({
        ...rsvp,
        [event.target.name]: event.target.value,

    });
}

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(rsvp);

    axios.post(`http://localhost:8080/registration/subscribe/event`, {
      eventId: id,
      usersId: 1,
      subscribe: rsvp.yesChoice
      
  }).then(res => {
      if (res.status = 200) {
          history.push("/Dashboard");
      }
  });
    };
        return (
          <div className="container">
          <div className="auth-wrapper">
          <div className="auth-inner">
            <form>
              <p>Would you attend this event?</p>
              <input type="text" placeholder="y/n" name="yesChoice" value={rsvp.yesChoice} onChange={handleChange}/> Y/N
              <br/>
              <br/>
              <button type="submit" className="btn btn-primary btn-block" onClick={handleSubmit}>Rsvp</button>
            </form>
          </div>
          </div>
          </div>
            
        );
}

export default Rsvp;