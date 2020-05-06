(defn- filter-candidate [r]
  (loop [head (first r)
         tail (rest r)
         result 0]
    (cond (empty? tail) result
          (= (inc (first head))
             (ffirst tail))
          (recur (first tail) (rest tail) (+ result (last head)))
          :else (recur (first tail) (rest tail) result)
          )))

(defn total-reports [r]
  (->> (frequencies r)
       (sort)
       (filter-candidate)))

(total-reports [3, 4, 3, 0, 2, 2, 3, 0, 0])
(total-reports [4, 2, 0])
(total-reports [1, 1, 1, 1, 1, 2, 2, 3])
