(def user/primes [2, 3, 5, 7, 11, 13])

(defn is-prime? [n]
  (loop [x (first primes) xs (rest primes)]
    (if x
      (if (= 0 (mod n x))
        false
        (recur (first xs) (rest xs)))
      true)))

(defn generate-primes [n]
  (when (< (peek primes) n)
    (doseq [x (range (inc (peek primes)) n)]
      (when (is-prime? x)
        (def user/primes (conj primes x))))) ;; not sure this best solution
  (take-while #(<= % n) primes))

(generate-primes 10)
(generate-primes 20)
(generate-primes 10000)
