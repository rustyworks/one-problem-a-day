(defn factorial [n]
  (if (<= n 1)
    1
    (* n (factorial (dec n)))))

(defn sum-of-factorial-nums [n]
  (loop [res 0
         remaining n]
    (if (zero? remaining)
      res
      (recur (+ res (mod remaining 10)) (quot remaining 10)))))

(sum-of-factorial-nums (factorial 10))
(sum-of-factorial-nums (factorial 100N))
