(ns euler.problem-003
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn -main
  "find the biggest prime factor of the given number"
  ([] (-main 600851475143N))
  ([number] (->> (take-while #(<= (* % %) number) primes)
                 (filter #(= (rem number %) 0))
                 (last))))
