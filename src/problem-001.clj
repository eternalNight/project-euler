(ns euler)

(defn divides?
  "Test if dividend can be evenly divided by divisor."
  [dividend divisor]
  (= (mod dividend divisor) 0))

(defn divides-any
  "Give a predicate to test if a number can be divided evenly by any one of the divisors"
  [& divisors]
  (fn [arg] (boolean (some #(divides? arg %) divisors))))

(defn divides-any?
  "Test if dividend can be evenly divided by any one of the divisors"
  [dividend & divisors]
  (boolean (some #(divides? dividend %) divisors)))

;; Filter version in left-to-right form
(defn problem-001
  "Calculate the sum of multiples of 3 or 5 below upper"
  [upper]
  (->> (range upper)
       (filter #(divides-any? % 3 5))
       (apply +)))

;; Recursive version
;; (defn problem-001
;;   [upper]
;;   (let [divisible? (divides-any 3 5)]
;;     (loop [n 1
;;            sum 0]
;;       (if (< n upper)
;;         (recur (inc n) (if (divisible? n) (+ sum n) sum))
;;         sum))))
