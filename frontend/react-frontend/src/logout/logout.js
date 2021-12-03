import React, { useState } from "react";
import { Link } from "react-router-dom";
import axios from 'axios';
import '../App.css';
import { useHistory } from "react-router-dom";

function Logout() {
    window.location.href = '/';
}
export default Logout;