import "./App.css";
import Header from "../Header/Header";
import Home from "../Home/Home";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Checkout from "../Checkout/Checkout";
import Login from "../Login/Login";
import { useState, useEffect } from "react";
import axios from "axios";
import { useStateValue } from "../StateProvider";
function App() {
  // const [auth, setAuth] = useState();
  // const getAuth = async () => {
  //   try {
  //     const response = await axios.get("http://localhost:8080/api/v1/auth");
  //     setAuth(response.data);
  //   } catch (err) {
  //     console.log(err);
  //   }
  // };
  const [product, setProducts] = useState();

  const getProduct = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/api/v1/product/all"
      );
      console.log(response.data);
      setProducts(response.data);
    } catch (err) {
      console.log(err);
    }
  };
  useEffect(() => {
    getProduct();
  }, []);
  return (
    <Router>
      <div className="app">
        <Routes>
          <Route path="/login" element={[<Login />]} />
          <Route path="/checkout" element={[<Header />, <Checkout />]} />
          <Route path="/" element={[<Header />, <Home product={product} />]} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
