(ns euler.problem-006)

(defn -main
  "Find the difference between square of the sum of the first nr
  numbers and sum of the squares"
  ([] (-main 100N))
  ([nr]
     (let [number-list (range (inc nr))]
       (apply + (for [x number-list y number-list :when (not= x y)] (* x y))))))
