(defn convert-time [seconds]
  (str
    (format "%02d" (quot seconds 3600))
    ":"
    (format "%02d" (quot (mod seconds 3600) 60))
    ":"
    (format "%02d" (mod seconds 60))))

(println (convert-time 3661))
(println (convert-time 61))
(println (convert-time 1))
(println (convert-time 63))
(println (convert-time 124))
(println (convert-time 53))
(println (convert-time 88))
(println (convert-time 120))
