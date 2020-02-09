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



