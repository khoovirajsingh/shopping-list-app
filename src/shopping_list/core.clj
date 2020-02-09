(ns shopping-list.core
  (:gen-class))

(def shoppings (atom []))

(defn add-shopping
  [shopping]
  (swap! shoppings conj shopping))

(loop [you-say (read-line)]
  (if (= you-say "quit")
    (println "we are done")
    (recur (do (println you-say)
               (read-line)))))





