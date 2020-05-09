(defn- isbn->nums [isbn]
  (keep #(cond (Character/isDigit %) (Character/digit % 10)
               (= \X %) 10) isbn))

(defn divisable-by? [divisor dividend]
  (zero? (mod dividend divisor)))

(defn- checksum? [nums]
  (->>
    (map * nums (range 10 0 -1))
    (reduce +)
    (divisable-by? 11)))

(defn isbn? [isbn]
  (and (boolean (re-matches #"(\d-?){9}[\dX]" isbn))
       (if (checksum? (isbn->nums isbn))
         "Valid"
         "Invalid")))


(isbn? "3-598-21508-8")
(isbn? "3-598-21508-5")
