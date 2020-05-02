(defn- will-catchup [x1 v1 x2 v2]
  (if (< (- v1 v2) 0)
    false
    (= 0 (mod (- x2 x1) (- v1 v2)))))

(defn overlap-same-place [x1 v1 x2 v2]
  (if (> x2 x1)
    (if (will-catchup x1 v1 x2 v2)
      "Overlap"
      "Tidak Overlap"
      )
    (if (will-catchup x2 v2 x1 v1)
      "Overlap"
      "Tidak Overlap")))

(overlap-same-place 0 3 4 2)
(overlap-same-place 0 2 5 3)
(overlap-same-place 0 10 4 3)
