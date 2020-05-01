(defn dom-wrapper [dom]
  (str
    "<" dom ">"
    "(.*?)"
    "<" "/" dom ">"))

(defn html-parser [dom html]
  (map #(get % 1)
       (re-seq
         (re-pattern
           (dom-wrapper dom))
         html)
       ))

(html-parser "ken" "<ken>goreng</ken>")
(html-parser "div" "<html><section><div>Kentang Oyeng</div></section><div>Kentang Goreng</div><span>I'm not div</span></html>")
