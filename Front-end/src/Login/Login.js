import React, { useState } from "react";
import "./Login.css";
import logo from "../images/amazonLogo.png";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Login() {
  const history = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setpassword] = useState("");
  const signIn = async (e) => {
    e.preventDefault();
    // try {
    const response = await axios
      .post("http://localhost:8080/api/v1/auth/authenticate", {
        email: email,
        password: password,
      })
      .then((response) => {
        history("/");
      })
      .catch((error) => {
        alert("Invalid email or password");
      });
    // console.log(response.data);

    // }
  };

  const CreateAccount = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/auth/register",
        {
          email: email,
          password: password,
        }
      );
      console.log(response.data);
      history("/");
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="Login">
      <Link to="/">
        <img className="Logo" src={logo} alt="" />
      </Link>
      <div className="container">
        <h1>Sign-in</h1>
        <form>
          <h5>E-mail</h5>
          <input
            type="text"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <h5>Password</h5>
          <input
            type="password"
            value={password}
            onChange={(e) => setpassword(e.target.value)}
          />
          <button className="signInButton" onClick={signIn} type="submit">
            Sign-in
          </button>
        </form>
        <p>
          By continuing, you agree to Amazon's Clone Conditions of Use and
          Privacy Notice.
        </p>
        <button onClick={CreateAccount} className="CreateButton">
          Create Account
        </button>
      </div>
    </div>
  );
}

export default Login;
