(defn decode [encoded-text]
  (->>
    (re-seq #"(\d+)?(\D)" cipher-text)
    (mapcat (fn [[_ n c]]
              (repeat (bigint (or n 1)) c)))
    (apply str)))
