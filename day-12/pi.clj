(defn pi-func
  ([]
   (pi-func 1000 1M))
  ([depth]
   (pi-func depth 1M))
  ([depth i]
   (if (= 0 depth)
     0M
     (+ 1M
        (* (with-precision 100 (/ i (+ 1M (* 2.0M i))))
           (pi-func (dec depth) (inc i)))))))

(def pi (* 2M (pi-func)))
(println Math.PI)
(println pi)
