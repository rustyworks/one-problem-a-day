(def rotation 13)
(def uppercase-a-char 65)
(def uppercase-z-char 90)
(def lowercase-a-char 97)
(def lowercase-z-char 122)

(defn to-ascii-code [words]
  (map (comp int char) words))

(defn swap [code a-char z-char]
  (let [chr (+ rotation code)]
    (if (> chr z-char)
      (+ (dec a-char) (- chr z-char))
      chr)))

(defn rotate [code]
  (cond
    (<= uppercase-a-char code uppercase-z-char)  ;; predicate
    (swap code uppercase-a-char uppercase-z-char)  ;; action
    (<= lowercase-a-char code lowercase-z-char)  ;; predicate
    (swap code lowercase-a-char lowercase-z-char)  ;; action
    :else code))

(defn rot-13 [words]
  (apply str (map char (map rotate (to-ascii-code words)))))

(rot-13 "KentanG GoReNk")
(rot-13 "XragnaT TbErAx")
