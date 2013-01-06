(ns euler.problem-007
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(defn -main
  ([] (-main 10001))
  ([n] (nth primes (dec n))))
