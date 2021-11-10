import React, { Component, useState } from "react";
import '../../../src/screen.css';



const Rsvp = () =>{
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
    // //axios.delete(`http://localhost:3004/getevents/${id}`).then(res => {
    //     if (res.status = 200) {
    //         history.push("/Dashboard");
    //     }
    };




        return (
          <div className="container">
          <div className="auth-wrapper">
          <div className="auth-inner">
            <form>
              <p>Would you attend this event?</p>
              <input type="text" placeholder="Y/N" name="yesChoice" value={rsvp.yesChoice} onChange={handleChange}/> Y/N
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