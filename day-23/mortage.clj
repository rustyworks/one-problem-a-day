(defn pow [n p]
  (reduce * (repeat p n)))

(defn calculate-mortgage [debt dp interest years]
  (let [P (- debt dp)
        r (/ interest 12 100)
        n (* years 12)
        u (* r (pow (+ 1 r) n))
        l (- (pow (+ 1 r) n) 1)]
    (int (* P (/ u l) n))))

(calculate-mortgage 300000 60000 3.8 30)
