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

(defn shopping->str
  [x]
  (str (:product x) " * " (:amount x) "\n"))

(defn shopping-printable
  [shoppings]
  (clojure.string/join
    "\n"
    (map shopping->str shoppings)))

(defn save-shopping-list
  [file shoppings]
  (spit file (shopping-printable shoppings)))


(defn -main
  [& args]
  (loop [choice (prompt "Enter a number:\n1. Add product\n2. Save shopping list")]
    (if (= choice "1")
      (do (add-product-to-shoppings)
          (recur (prompt "Enter a number:\n1. Add product\n2. Save shopping list")))
      (if (= choice "2")
        (do (save-shopping-list "./things-to-buy.txt" @shoppings)
          (println "Shopping list saved"))
        (do (println "Invalid choice!!! Try again")
            (recur (prompt "Enter a number:\n1. Add product\n2. Save shopping list")))))))
