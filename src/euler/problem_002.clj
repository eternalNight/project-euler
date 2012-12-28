(ns euler.problem-002)

(defn fib
  "Returns a lazy sequence of the Fibonacci numbers"
  []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0N 1N])))

(defn -main
  "Adding even Fibonacci numbers smaller than the upper bound"
  ([] (-main 4000000))
  ([upper] (->> (fib)
                (take-while #(< % upper))
                (filter even?)
                (apply +))))
