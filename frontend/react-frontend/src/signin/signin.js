import React, { useState } from "react";
import { Link } from "react-router-dom";
import axios from 'axios';
import '../App.css';
import { useHistory } from "react-router-dom";

const Signin = () => {
    //const sign_up_url='http://localhost:3000/sign-up-process';
    const sign_in_url = 'http://localhost:8080/users/login';
    let history = useHistory();
    const [formDta, setformDta] = useState({
        email: "",
        password: "",
    });
    const handleChange = (event) => {
        setformDta({
            ...formDta,
            [event.target.name]: event.target.value,
        });
    }
    console.log(formDta);
    const handleSubmit = (event) => {
        event.preventDefault();
        axios.post(sign_in_url, {
            email: formDta.email,
            password: formDta.password
        }).then(res => {
            console.log(res);
            history.push("/Dashboard");
        });


    }

    return (
        <div className="container">
            <div className="auth-wrapper">
                <div className="auth-inner">
                    <form>
                        <h3>Sign In</h3>

                        <div className="form-group">
                            <label>Email address</label>
                            <input type="email" className="form-control" name="email" value={formDta.email} onChange={handleChange} />
                        </div>

                        <div className="form-group">
                            <label>Password</label>
                            <input type="password" className="form-control" name="password" value={formDta.password} onChange={handleChange} />
                        </div>

                        <br/>

                        <button type="submit" className="btn btn-primary btn-block" onClick={handleSubmit}>Submit</button>

                        <div class="container">
                            <div class="row">
                                <div class="col-sm">
                                    <p className="forgot-password text-right">
                                        Forgot <a href="/reset-password">password?</a>
                                    </p>
                                </div>
                                <div class="col-sm">
                                    <p className="forgot-password text-right">
                                        Not <a href="/sign-up">Registered?</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}
export default Signin;