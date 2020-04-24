(defn toggle-case [s]
  (if (= (clojure.string/upper-case s) (str s))
    (clojure.string/lower-case s)
    (clojure.string/upper-case s)))

(defn swap-case [s]
  (if (not (empty? s))
    (str (toggle-case (first s)) (swap-case (rest s)))
    ""))

(println (swap-case "hEllO wOrLd"))
