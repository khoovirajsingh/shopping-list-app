(ns shopping-list.core
  (:gen-class))

(def shoppings (atom []))

(defn add-shopping
  [shopping]
  (swap! shoppings conj shopping))

(defn prompt
  [msg]
  (println msg)
  (read-line))

(defn add-product-to-shoppings
  []
  (let [product (prompt "What to buy?")
        amount (prompt "How many?")]
    (add-shopping {:product product 
                   :amount amount})))



