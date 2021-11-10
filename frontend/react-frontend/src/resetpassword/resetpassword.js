import React from "react";

export default class signin extends React.Component {
    constructor(props) {
        super(props);
        this.state = {forgot: false};
    }

    login() {
        alert('Login will work here');
    }
    forgot() {
        this.setState({forgot: true})
    }

    render() {
        return (
            <div>
                {this.state.forgot === false && <div>

                </div>}
                {this.state.forgot === false && <ForgotPassword/>}
            </div>
        );
    }
}

class ForgotPassword extends React.Component {

    reset() {
        alert('Password is sent to your email');
    }

    render() {
        return (<div><h2>Enter your registered email address</h2>
            <input/>
            <button onClick={this.reset.bind(this)}>Reset Password</button>

        </div>)
    }
}