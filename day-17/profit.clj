(defn- profit-list [stocks]
  (loop [next-stock (first stocks)
         rest-stocks (rest stocks)
         min-stock next-stock
         max-profit 0
         profits []]
    (if next-stock
      (if (> min-stock next-stock)
        (recur
          (first rest-stocks)
          (rest rest-stocks)
          next-stock
          0
          (conj profits max-profit))
        (recur
          (first rest-stocks)
          (rest rest-stocks)
          min-stock
          (- next-stock min-stock)
          (conj profits max-profit)))
      (conj profits max-profit))))

(defn max-profit [stocks]
  (reduce max (profit-list stocks)))

(max-profit [5000 4900 5100 5200])
(max-profit [5000 4900 5000 4700 4600 4300])
(max-profit [5000 4900 5000 4700 4600 5000])
(max-profit [4000 5000 5000 4700 4600 4700])
(max-profit [1000 900 1000 800 1000])
(max-profit [5000 5000])
(max-profit [5000 4000])
