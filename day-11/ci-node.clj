(defn get-max-ci-time [total-node testing-time]
  (let [sorted-testing-time (reverse (sort testing-time))]
    (if (>= total-node (count sorted-testing-time))
      (first sorted-testing-time)
      (loop [nodes (take total-node sorted-testing-time)
             remaining-test (drop total-node sorted-testing-time)]
        (let [head (first remaining-test)
              minimum-time (reduce min nodes)
              index (.indexOf nodes minimum-time)]
          (if (nil? head)
            (reduce max nodes)
            (recur (update (vec nodes) index #(+ head %)) (rest remaining-test))))))))

(get-max-ci-time 10 [3 7 9])  ; 9
(get-max-ci-time 3 [10 20 30 40 50])  ; 50
(get-max-ci-time 4 [3 2 1 2 1 3 5 7])  ; 7
(get-max-ci-time 3 [1 1 1 1 1 1 1 1 1 1 1 1 1 1 100 1 1 1 1 1])  ; 100
(get-max-ci-time 4 [219 101 305 222 259])  ; 320
