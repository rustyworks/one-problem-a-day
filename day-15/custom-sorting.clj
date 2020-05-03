(ns custom-sorting
  (:require [clojure.string :as s]))

(defn- get-uppercase-letter [sentences]
  (->>
    sentences
    (filter #(Character/isLetter %))
    (filter #(= (s/upper-case %) (str %)))
    (sort)))

(defn- get-lowercase-letter [sentences]
  (->>
    sentences
    (filter #(Character/isLetter %))
    (filter #(= (s/lower-case %) (str %)))
    (sort)))

(defn- get-odd-number [sentences]
  (->>
    sentences
    (filter #(Character/isDigit %))
    (filter #(= 1 (mod (int %) 2))) 
    (sort)))

(defn- get-even-number [sentences]
  (->>
    sentences
    (filter #(Character/isDigit %)) 
    (filter #(= 0 (mod (int %) 2))) 
    (sort)))

(defn custom-sorting [s]
  (apply str
         (->
           []
           (into (get-lowercase-letter s))
           (into (get-uppercase-letter s))
           (into (get-odd-number s))
           (into (get-even-number s)))))

(custom-sorting "Kentang1234")
