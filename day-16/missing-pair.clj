(defn missing-pair [array]
  (let [sorted-array (sort array)]
    (->>
      sorted-array
      (partition-by identity)
      (filter #(odd? (count %)))
      ffirst)))

(missing-pair [9, 3, 9, 3, 9, 7, 9])
(missing-pair [1, 2, 3, 4, 3, 2, 1])
