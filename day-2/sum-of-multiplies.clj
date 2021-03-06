(defn generate-3-or-5 [limit]
  (filter
    #(or (= 0 (mod % 3)) (= 0 (mod % 5)))
    (range limit)))

(apply + (generate-3-or-5 1000))
