(ns shopping-list.core-test
  (:require [clojure.test :refer :all]
            [shopping-list.core :refer :all]))

(deftest add-shopping-test
  (testing "Adding item to shopping list."
    (is (= 1 (count (add-shopping {:product "Milk" :amount "2 liter"}))))))
