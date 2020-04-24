;; Bruteforce unoptimized solution

(defn counter-generator [limit]
  (filter
    (fn [arr] (< (first arr) (second arr)))
    (for [x (range limit) y (range (inc limit))]
      [x y])))

(defn generate-words [string]
  (for [x (counter-generator (count string))]
    (apply subs string [(first x) (last x)])))

(defn longest-palindrome [words]
  (apply max (map count (filter palindrome? words))))

(defn longest-palindrome [string]
  (if (palindrome? string)
    string
    (max
      (for [x (counter-generator (count string))]
       (count
         (longest-palindrome
           (apply
             subs
             string
             [(first x) (last x)])))))))

(longest-palindrome "telugugu")
(longest-palindrome "kasurusak")
(longest-palindrome "array")
(longest-palindrome "a")
(longest-palindrome "aa")
(longest-palindrome "kentang")
(longest-palindrome "xabbadffdx")
(longest-palindrome "abcxxx123")
