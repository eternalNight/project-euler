(ns euler.problem-004)

(defn palindrome
  "with the given number (abcd), generate the palindrome (abcddcba)"
  [number]
  (let [number-str (Integer/toString number)]
    (Integer. (apply str (concat number-str (reverse number-str))))))

(defn divide-in-range
  "given lower and upper bound, generate a predicate for judging if a
  number can be divided in to two products both falling in the range
  [lower, upper)"
  [lower upper]
  (fn [number]
    (->> (range lower upper)
         (filter #(= (rem number %) 0))
         (map #(/ number %))
         (some #(and (>= % lower) (< % upper)))
         (boolean))))

(defn -main
  "find the biggest palindrome product of two 3-digit numbers"
  []
  (->> (range 997 100 -1)
       (map palindrome)
       (filter (divide-in-range 100 1000))
       (first)))
