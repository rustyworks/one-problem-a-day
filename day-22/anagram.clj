(ns anagram
  (:require [clojure.string :as str]))


(defn anagrams-for [word prospects]
  (let [word (str/lower-case word)
        sorted-word (sort word)
        anagram? #(let [p (str/lower-case %)]
                    (and (not= p word)
                         (= (sort p) sorted-word)))]
    (filter anagram? prospects)))
