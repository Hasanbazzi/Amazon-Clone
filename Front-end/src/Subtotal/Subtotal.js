import React from "react";

import "./Subtotal.css";
import { useStateValue } from "../StateProvider";
import { getBasketTotal } from "../reducer";
// import { Button } from "@mui/material";
function Subtotal() {
  const [{ basket }] = useStateValue();

  return (
    <div className="subtotal">
      <div>
        <p>
          Subtotal ({basket.length} items):
          <strong>${getBasketTotal(basket)}</strong>
        </p>
        <small className="subtotal_gift">
          <input type="checkbox" /> This order contains a gift
        </small>
      </div>

      <button>Proceed to Checkout</button>
    </div>
  );
}

export default Subtotal;
