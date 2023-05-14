import React, { useEffect, useState } from "react";
import "./Home.css";
import Product from "../Product/Product";
import axios from "axios";
import { useStateValue } from "../StateProvider";
function Home({ product = [] }) {
  // const startIdx = 1 ? 0 : 2 ? 2 : product.length - 1;
  // const endIdx = 1 ? 1 : 2 ? 4 : product.length - 1;
  //slice(startIdx, endIdx + 1)

  return (
    <div className="home">
      <div className="home_container">
        <img
          className="home_image"
          src="https://images-eu.ssl-images-amazon.com/images/G/02/digital/video/merch2016/Hero/Covid19/Generic/GWBleedingHero_ENG_COVIDUPDATE__XSite_1500x600_PV_en-GB._CB428684220.jpg"
          alt=""
        />

        <div className=" home_row">
          {product.slice(0, 2).map((products) => (
            <Product
              id={products.id}
              title={products.title}
              image={products.image}
              price={products.price}
              rating={products.rating}
            />
          ))}
        </div>
        <div className=" home_row">
          {product.slice(2, 5).map((products) => (
            <Product
              id={products.id}
              title={products.title}
              image={products.image}
              price={products.price}
              rating={products.rating}
            />
          ))}
        </div>
        <div className=" home_row">
          {product.slice(5, 6).map((products) => (
            <Product
              id={products.id}
              title={products.title}
              image={products.image}
              price={products.price}
              rating={products.rating}
            />
          ))}
        </div>
      </div>
    </div>
  );
}

export default Home;
