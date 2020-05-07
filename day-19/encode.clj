(defn encode [plain-text]
  (->>
    (partition-by identity plain-text)
    (mapcat (juxt count first))
    (remove #{1})
    (apply str)))

(encode "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB")
