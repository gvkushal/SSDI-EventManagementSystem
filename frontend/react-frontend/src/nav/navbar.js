
import React from "react";
import { Link, NavLink } from "react-router-dom";
const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light">
      <div className="container">
        <Link className="navbar-brand" to="/">
          Event Management
        </Link>

        <Link to="/admin">
          Admin
        </Link>

        <Link to="/logout">
          Logout
        </Link>


      </div>
    </nav>
  );
};

export default Navbar;
