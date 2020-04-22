(defn generate-3-or-5 [limit]
  (filter
    #(or (= 0 (mod % 3)) (= 0 (mod % 5)))
    (range limit)))

(defn sum [array]
  (reduce + array))


(println (sum (generate-3-or-5 10)))
(println (sum (generate-3-or-5 1000))) 
