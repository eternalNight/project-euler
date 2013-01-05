(ns euler.problem-005
  (:use [clojure.contrib.lazy-seqs :only (primes)]
        [clojure.contrib.math :only (expt)]))

(defn -main
  "Find the smallest integer that is divisible by all the numbers in [1, range]"
  ([] (-main 20))
  ([range] (let [factors (take-while #(<= % range) primes)]
            (->> (map #(int (Math/floor (/ (Math/log range) (Math/log %)))) factors)
                 (map expt factors)
                 (reduce *)))))
